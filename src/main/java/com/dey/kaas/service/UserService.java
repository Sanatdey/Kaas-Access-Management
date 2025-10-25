package com.dey.kaas.service;

import java.util.List;
import java.util.Optional;

import com.dey.kaas.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dey.kaas.dto.request.LoginRequestDto;
import com.dey.kaas.dto.request.UserRequestDto;
import com.dey.kaas.dto.response.LoginResponseDto;
import com.dey.kaas.dto.response.UserResponseDto;
import com.dey.kaas.entiity.User;
import com.dey.kaas.exeption.InvalidUsernameOrPasswordException;
import com.dey.kaas.mapper.UserMapper;
import com.dey.kaas.repository.UserRepository;

@Service
public class UserService {
	
    UserRepository userRepository;
    UserMapper mapper;
	PasswordEncoder passwordEncoder;
	
	CompanyService companyService;
	AccessService accessService;
	AccessGroupService accessGroupService;

    JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
	
	public UserService(UserRepository userRepository,UserMapper mapper, PasswordEncoder passwordEncoder  , CompanyService companyService,
                       AccessService accessService, AccessGroupService accessGroupService , JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
		
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.mapper = mapper;
		this.companyService = companyService;
		this.accessService = accessService;
		this.accessGroupService = accessGroupService;
        this.jwtUtil = jwtUtil;

        this.authenticationManager = authenticationManager;
    }
	
	public ResponseEntity<List<?>> getAllUsers() {
		return ResponseEntity.ok(userRepository.findAll().stream().map(user -> mapper.toDto(user)).toList());
	}

    public User getUserByPhoneNumber(String phoneNumber){
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Phone number with " + phoneNumber + " is not Found!");
    }

    public User getUserByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Phone number with " + email + " is not Found!");
    }

    public User getUser(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("User Not Found!");
    }

    public ResponseEntity<UserResponseDto> getUserResponse(int id){
        return ResponseEntity.ok().body(mapper.toDto(getUser(id)));
    }

    public ResponseEntity<UserResponseDto> getUserResponse() throws InvalidUsernameOrPasswordException {
        if(SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            return ResponseEntity.ok().body(mapper.toDto(getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())));
        }
        throw new InvalidUsernameOrPasswordException("Please authenticate !");
    }
	
	
	public ResponseEntity<LoginResponseDto> login(LoginRequestDto dto) throws InvalidUsernameOrPasswordException {
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(dto.username(),dto.password());
		if(authenticationManager.authenticate(auth).isAuthenticated()) {
			return ResponseEntity.ok(new LoginResponseDto(dto.username(), jwtUtil.generateToken(dto.username())));
		}
		throw new InvalidUsernameOrPasswordException();
	}
	
	public ResponseEntity<UserResponseDto> register(UserRequestDto dto) {
		User user = mapper.toEntity(dto);
		user.setCompany(companyService.getCompany(dto.companyId()));
		user.setPassword(passwordEncoder.encode(dto.password()));
		user.setAccesses(dto.accessIds().stream().map(a -> accessService.getAccess(a)).toList());
		user.setAccessgroups(dto.accessGroupIds().stream().map(a -> accessGroupService.getAccessGroup(a)).toList());
        User user1 = userRepository.save(user);
		return ResponseEntity.ok(mapper.toDto(user1));
	}

}
