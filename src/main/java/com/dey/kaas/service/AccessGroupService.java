package com.dey.kaas.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dey.kaas.dto.request.AccessGroupRequestDto;
import com.dey.kaas.entiity.AccessGroup;
import com.dey.kaas.exeption.CompanyNotFoundException;
import com.dey.kaas.mapper.AccessGroupMapper;
import com.dey.kaas.repository.AccessGroupRepository;

@Service
public class AccessGroupService {
	
	AccessGroupRepository accessGroupRepository;
	AccessGroupMapper mapper;
	AccessService accessService;
	
	public AccessGroupService(AccessGroupRepository accessGroupRepository , AccessGroupMapper mapper,AccessService accessService) {
		this.accessGroupRepository = accessGroupRepository;
		this.mapper = mapper;
		this.accessService = accessService;
	}
	
	public ResponseEntity<Iterable<AccessGroup>> getAllAccessGroup() {
		return ResponseEntity.ok().body(accessGroupRepository.findAll());
	}
	
	public ResponseEntity<AccessGroup> addAccessGroup(AccessGroupRequestDto dto) {
		AccessGroup r = mapper.toEntity(dto);
		r.setAccesses(accessService.getAccesses(dto.accessIds()));
		return ResponseEntity.ok().body(accessGroupRepository.save(r));
	}

	public AccessGroup getAccessGroup(Integer id) {
		return accessGroupRepository.findById(id).orElseThrow( () ->  new CompanyNotFoundException("exp") );
	}
	

}
