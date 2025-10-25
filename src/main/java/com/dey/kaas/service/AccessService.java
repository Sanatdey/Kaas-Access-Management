package com.dey.kaas.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dey.kaas.dto.request.AccessRequestDto;
import com.dey.kaas.entiity.Access;
import com.dey.kaas.exeption.AccessOrAccessGroupNotFoundException;
import com.dey.kaas.exeption.CompanyNotFoundException;
import com.dey.kaas.mapper.AccessMapper;
import com.dey.kaas.repository.AccessRepository;

@Service
public class AccessService {
	
	AccessRepository accessRepository;
	AccessMapper mapper;
	ResourceService resourceService;
	ActionService actionService;
	
	public AccessService(AccessRepository accessRepository , AccessMapper mapper,ResourceService resourceService, ActionService actionService) {
		this.accessRepository = accessRepository;
		this.mapper = mapper;
		this.resourceService =resourceService;
		this.actionService = actionService;
	}
	
	public ResponseEntity<Iterable<Access>> getAllAccess() {
		return ResponseEntity.ok().body(accessRepository.findAll());
	}
	
	public ResponseEntity<Access> addAccess(AccessRequestDto dto) {
		Access r = mapper.toEntity(dto);
		r.setResource(resourceService.getResource(dto.resourceId()));
		r.setAction(actionService.getActions(dto.actionId()));
		return ResponseEntity.ok().body(accessRepository.save(r));
	}

	public Access getAccess(Integer id) {
		return accessRepository.findById(id).orElseThrow( () ->  new AccessOrAccessGroupNotFoundException("exp") );
	}
	
	public List<Access> getAccesses(List<Integer> ids){
		return ids.stream().map(this::getAccess).toList();
	}

    public ResponseEntity<Access> updateAccess(int id , AccessRequestDto dto){
        Access access = getAccess(id);
        Access a = mapper.toEntity(dto);
        access.setAction(a.getAction());
        access.setName(a.getName());
        return ResponseEntity.ok().body(accessRepository.save(access));
    }

    public ResponseEntity<Access> deleteAccess(int id){
        Access access = getAccess(id);
        accessRepository.delete(access);
        return ResponseEntity.ok().build();
    }


}
