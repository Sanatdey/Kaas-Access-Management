package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/action/{id}")
    public ResponseEntity<?> updateAction(@PathVariable int id ,@RequestBody ActionRequestDto dto) {
        return actionService.updateAction(id,dto);
    }

    @DeleteMapping("/action/{id}")
    public ResponseEntity<?> deleteAction(@PathVariable int id) {
        return actionService.deleteAction(id);
    }

}
