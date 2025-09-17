package com.dey.kaas.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
	
	public UserService(UserRepository userRepository,UserMapper mapper, PasswordEncoder passwordEncoder  , CompanyService companyService, AccessService accessService, AccessGroupService accessGroupService) {
		
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.mapper = mapper;
		this.companyService = companyService;
		this.accessService = accessService;
		this.accessGroupService = accessGroupService;
		
	}
	
	public ResponseEntity<List<?>> getAllUsers() {
		return ResponseEntity.ok(userRepository.findAll().stream().map(user -> mapper.toDto(user)).toList());
	}
	
	
	public ResponseEntity<LoginResponseDto> login(LoginRequestDto dto) throws InvalidUsernameOrPasswordException {
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(dto.username(),dto.password());
		if(auth.isAuthenticated()) {
			return ResponseEntity.ok(new LoginResponseDto(dto.username(), "ABCD"));
		}
		throw new InvalidUsernameOrPasswordException();
	}
	
	public ResponseEntity<UserResponseDto> register(UserRequestDto dto) {
		User user = mapper.toEntity(dto);
		user.setCompany(companyService.getCompany(dto.companyId()));
		user.setPassword(passwordEncoder.encode(dto.password()));
		user.setAccesses(dto.accessIds().stream().map(a -> accessService.getAccess(a)).toList());
		user.setAccessgroups(dto.accessGroupIds().stream().map(a -> accessGroupService.getAccessGroup(a)).toList());
		return ResponseEntity.ok(mapper.toDto(userRepository.save(user)));
	}

}
