package com.dey.kaas.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dey.kaas.dto.request.ActionRequestDto;
import com.dey.kaas.entiity.Action;
import com.dey.kaas.exeption.CompanyNotFoundException;
import com.dey.kaas.mapper.ActionMapper;
import com.dey.kaas.repository.ActionRepository;

@Service
public class ActionService {
	
	ActionRepository actionRepository;
	ActionMapper mapper;

	
	public ActionService(ActionRepository actionRepository , ActionMapper mapper) {
		this.actionRepository = actionRepository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<Iterable<Action>> getAllActions() {
		return ResponseEntity.ok().body(actionRepository.findAll());
	}
	
	public ResponseEntity<Action> addAction(ActionRequestDto dto) {
		Action r = mapper.toEntity(dto);
		return ResponseEntity.ok().body(actionRepository.save(r));
	}

	public Action getAction(Integer id) {
		return actionRepository.findById(id).orElseThrow( () ->  new CompanyNotFoundException("exp") );
	}
	
	public List<Action> getActions(List<Integer> ids){
		return ids.stream().map(this::getAction).toList();
	}

    public ResponseEntity<Action> updateAction(int id,ActionRequestDto dto) {
        Action action = getAction(id);
        Action a = mapper.toEntity(dto);
        action.setName(a.getName());
        return ResponseEntity.ok().body(actionRepository.save(action));
    }

    public ResponseEntity<?> deleteAction(int id) {
        Action action = getAction(id);
        actionRepository.delete(action);
        return ResponseEntity.ok().build();
    }

}
