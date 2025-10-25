package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/resources/{id}")
    public ResponseEntity<?> updatedResourceType(@PathVariable int id, @RequestBody ResourceRequestDto dto) {
        return resourceService.updateResource(id,dto);
    }

    @DeleteMapping("/resources/{id}")
    public ResponseEntity<?> deleteResourceType(@PathVariable int id) {
        return resourceService.deleteCompany(id);
    }

}
