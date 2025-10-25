package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/resources/types/{id}")
    public ResponseEntity<?> addResourceType(@PathVariable int id, @RequestBody ResourceTypeRequestDto dto) {
        return resourceTypeService.updateResourceType(id,dto);
    }

    @DeleteMapping("/resources/types/{id}")
    public ResponseEntity<?> addResourceType(@PathVariable int id) {
        return resourceTypeService.deleteAction(id);
    }

}
