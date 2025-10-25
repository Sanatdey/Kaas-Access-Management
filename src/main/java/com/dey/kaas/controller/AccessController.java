package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dey.kaas.dto.request.AccessRequestDto;
import com.dey.kaas.service.AccessService;

@RestController
public class AccessController {

	AccessService accessService;
	
	public AccessController(AccessService accessService){
		this.accessService = accessService;
	}
	
	
	@GetMapping("/accesses")
	public ResponseEntity<?> getAllAccess() {
		return accessService.getAllAccess();
	}
	
	@PostMapping("/accesses")
	public ResponseEntity<?> addAccess(@RequestBody AccessRequestDto dto) {
		return accessService.addAccess(dto);
	}

    @PutMapping("/accesses/{id}")
    public ResponseEntity<?> updateAccess(@PathVariable int id, @RequestBody AccessRequestDto dto) {
        return accessService.updateAccess(id,dto);
    }

}
