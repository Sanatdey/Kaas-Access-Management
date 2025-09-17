package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dey.kaas.dto.request.ActionRequestDto;
import com.dey.kaas.service.ActionService;

@RestController
public class ActionController {

	ActionService actionService;
	
	public ActionController(ActionService actionService){
		this.actionService = actionService;
	}
	
	
	@GetMapping("/action")
	public ResponseEntity<?> getAllAction() {
		return actionService.getAllActions();
	}
	
	@PostMapping("/action")
	public ResponseEntity<?> addAction(@RequestBody ActionRequestDto dto) {
		return actionService.addAction(dto);
	}

}
