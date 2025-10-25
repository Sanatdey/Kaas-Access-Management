package com.dey.kaas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dey.kaas.dto.request.LoginRequestDto;
import com.dey.kaas.dto.request.UserRequestDto;
import com.dey.kaas.exeption.InvalidUsernameOrPasswordException;
import com.dey.kaas.service.UserService;

@Slf4j
@RestController
public class HomeController {
	
	UserService userService;
	
	HomeController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		return userService.getAllUsers();
	}

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        return userService.getUserResponse(id);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getPofile() throws InvalidUsernameOrPasswordException {
        return userService.getUserResponse();
    }
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto dto) throws InvalidUsernameOrPasswordException {
        log.info("User : "+dto.username() + " Password : " + dto.password());
		return userService.login(dto);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRequestDto dto) throws InvalidUsernameOrPasswordException {
		return userService.register(dto);
	}

}
