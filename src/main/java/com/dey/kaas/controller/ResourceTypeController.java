package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dey.kaas.dto.request.ResourceTypeRequestDto;
import com.dey.kaas.service.ResourceTypeService;

@RestController
public class ResourceTypeController {

	ResourceTypeService resourceTypeService;
	
	public ResourceTypeController(ResourceTypeService resourceTypeService){
		this.resourceTypeService = resourceTypeService;
	}
	
	
	@GetMapping("/resources/types")
	public ResponseEntity<?> getAllResourceType() {
		return resourceTypeService.getAllResourceType();
	}
	
	@PostMapping("/resources/types")
	public ResponseEntity<?> addResourceType(@RequestBody ResourceTypeRequestDto dto) {
		return resourceTypeService.addResourceType(dto);
	}

}
