package com.dey.kaas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dey.kaas.dto.request.AccessGroupRequestDto;
import com.dey.kaas.dto.response.AccessGroupResponseDto;
import com.dey.kaas.entiity.AccessGroup;

@Mapper(componentModel = "spring", uses = {AccessMapper.class})
public interface AccessGroupMapper {
	
	public AccessGroupResponseDto toDto(AccessGroup type);
	
	@Mapping(target="accesses",ignore=true)
	public AccessGroup toEntity(AccessGroupRequestDto dto);

}
