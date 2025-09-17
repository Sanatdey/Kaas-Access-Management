package com.dey.kaas.mapper;

import org.mapstruct.Mapper;

import com.dey.kaas.dto.request.ActionRequestDto;
import com.dey.kaas.dto.response.ActionResponseDto;
import com.dey.kaas.entiity.Action;

@Mapper(componentModel = "spring")
public interface ActionMapper {
	
	public ActionResponseDto toDto(Action type);
	
	public Action toEntity(ActionRequestDto dto);

}
