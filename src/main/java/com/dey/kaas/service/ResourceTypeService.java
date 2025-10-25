package com.dey.kaas.service;

import com.dey.kaas.dto.request.ActionRequestDto;
import com.dey.kaas.entiity.Action;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dey.kaas.dto.request.ResourceTypeRequestDto;
import com.dey.kaas.entiity.ResourceType;
import com.dey.kaas.exeption.CompanyNotFoundException;
import com.dey.kaas.mapper.ResourceTypeMapper;
import com.dey.kaas.repository.ResourceTypeRepository;

@Service
public class ResourceTypeService {
	
	ResourceTypeRepository resourceTypeRepository;
	ResourceTypeMapper mapper;
	CompanyService companyService;
	
	public ResourceTypeService(ResourceTypeRepository resourceTypeRepository , ResourceTypeMapper mapper,CompanyService companyService) {
		this.resourceTypeRepository = resourceTypeRepository;
		this.mapper = mapper;
		this.companyService =companyService;
	}
	
	public ResponseEntity<Iterable<ResourceType>> getAllResourceType() {
		return ResponseEntity.ok().body(resourceTypeRepository.findAll());
	}
	
	public ResponseEntity<ResourceType> addResourceType(ResourceTypeRequestDto dto) {
		ResourceType r = mapper.toEntity(dto);
		r.setCompany(companyService.getCompany(dto.companyId()));
		return ResponseEntity.ok().body(resourceTypeRepository.save(r));
	}

	public ResourceType getResourceType(Integer id) {
		return resourceTypeRepository.findById(id).orElseThrow( () ->  new CompanyNotFoundException("exp") );
	}

    public ResponseEntity<ResourceType> updateResourceType(int id, ResourceTypeRequestDto dto) {
        ResourceType resourceType = getResourceType(id);
        ResourceType r = mapper.toEntity(dto);
        resourceType.setName(r.getName());
        return ResponseEntity.ok().body(resourceTypeRepository.save(resourceType));
    }

    public ResponseEntity<?> deleteAction(int id) {
        ResourceType resourceType = getResourceType(id);
        resourceTypeRepository.delete(resourceType);
        return ResponseEntity.ok().build();
    }
	

}
