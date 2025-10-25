package com.dey.kaas.service;

import com.dey.kaas.dto.request.CompanyRequestDto;
import com.dey.kaas.entiity.Company;
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

    public ResponseEntity<Resource> updateResource(int id, ResourceRequestDto dto) {
        Resource resource = getResource(id);
        Resource r = mapper.toEntity(dto);
        resource.setName(r.getName());
        resource.setType(r.getType());
        return ResponseEntity.ok().body(resourceRepository.save(resource));
    }

    public ResponseEntity<?> deleteCompany(int id) {
        Resource resource = getResource(id);
        resourceRepository.delete(resource);
        return ResponseEntity.ok().build();
    }

}
