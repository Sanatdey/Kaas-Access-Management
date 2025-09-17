package com.dey.kaas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dey.kaas.dto.request.ResourceRequestDto;
import com.dey.kaas.entiity.Resource;
import com.dey.kaas.exeption.CompanyNotFoundException;
import com.dey.kaas.mapper.ResourceMapper;
import com.dey.kaas.repository.ResourceRepository;

@Service
public class ResourceService {
	
	ResourceRepository resourceRepository;
	ResourceMapper mapper;
	ResourceTypeService resourceTypeService;
	
	public ResourceService(ResourceRepository resourceRepository , ResourceMapper mapper,ResourceTypeService resourceTypeService) {
		this.resourceRepository = resourceRepository;
		this.mapper = mapper;
		this.resourceTypeService =resourceTypeService;
	}
	
	public ResponseEntity<Iterable<Resource>> getAllResource() {
		return ResponseEntity.ok().body(resourceRepository.findAll());
	}
	
	public ResponseEntity<Resource> addResource(ResourceRequestDto dto) {
		Resource r = mapper.toEntity(dto);
		r.setType(resourceTypeService.getResourceType(dto.typeId()));
		return ResponseEntity.ok().body(resourceRepository.save(r));
	}

	public Resource getResource(Integer id) {
		return resourceRepository.findById(id).orElseThrow( () ->  new CompanyNotFoundException("exp") );
	}
	

}
