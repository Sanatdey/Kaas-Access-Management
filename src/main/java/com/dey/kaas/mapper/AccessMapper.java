package com.dey.kaas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dey.kaas.dto.request.AccessRequestDto;
import com.dey.kaas.dto.response.AccessResponseDto;
import com.dey.kaas.entiity.Access;

@Mapper(componentModel = "spring", uses = {ResourceMapper.class, ActionMapper.class})
public interface AccessMapper {
	
	public AccessResponseDto toDto (Access access);
	
	@Mapping(target="resource",ignore=true)
	@Mapping(target="action", ignore=true)
	public Access toEntity(AccessRequestDto dto);

}
