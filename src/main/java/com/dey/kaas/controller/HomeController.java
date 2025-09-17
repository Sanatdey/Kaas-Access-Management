package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dey.kaas.dto.request.LoginRequestDto;
import com.dey.kaas.dto.request.UserRequestDto;
import com.dey.kaas.exeption.InvalidUsernameOrPasswordException;
import com.dey.kaas.service.UserService;

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
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto dto) throws InvalidUsernameOrPasswordException {
		return userService.login(dto);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRequestDto dto) throws InvalidUsernameOrPasswordException {
		return userService.register(dto);
	}

}
