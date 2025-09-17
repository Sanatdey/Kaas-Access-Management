package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dey.kaas.dto.request.ResourceRequestDto;
import com.dey.kaas.service.ResourceService;

@RestController
public class ResourceController {

	ResourceService resourceService;
	
	public ResourceController(ResourceService resourceService){
		this.resourceService = resourceService;
	}
	
	
	@GetMapping("/resources")
	public ResponseEntity<?> getAllResourceType() {
		return resourceService.getAllResource();
	}
	
	@PostMapping("/resources")
	public ResponseEntity<?> addResourceType(@RequestBody ResourceRequestDto dto) {
		return resourceService.addResource(dto);
	}

}
