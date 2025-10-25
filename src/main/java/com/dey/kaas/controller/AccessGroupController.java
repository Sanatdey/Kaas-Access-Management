package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dey.kaas.dto.request.AccessGroupRequestDto;
import com.dey.kaas.service.AccessGroupService;

@RestController
public class AccessGroupController {

	AccessGroupService accessGroupService;
	
	public AccessGroupController(AccessGroupService accessGroupService){
		this.accessGroupService = accessGroupService;
	}
	
	@GetMapping("/accessGroups")
	public ResponseEntity<?> getAllResourceType() {
		return accessGroupService.getAllAccessGroup();
	}
	
	@PostMapping("/accessGroups")
	public ResponseEntity<?> addResourceType(@RequestBody AccessGroupRequestDto dto) {
		return accessGroupService.addAccessGroup(dto);
	}

    @PutMapping("/accessGroups")
    public ResponseEntity<?> updateResourceType(@PathVariable int id, @RequestBody AccessGroupRequestDto dto) {
        return accessGroupService.updateAccessGroup(id,dto);
    }

}
