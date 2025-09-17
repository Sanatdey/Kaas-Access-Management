package com.dey.kaas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dey.kaas.dto.request.ResourceRequestDto;
import com.dey.kaas.dto.response.ResourceResponseDto;
import com.dey.kaas.entiity.Resource;

@Mapper(componentModel = "spring", uses = {ResourceTypeMapper.class})
public interface ResourceMapper {
	
	public ResourceResponseDto toDto(Resource resource);
	
	@Mapping(target="type",ignore=true)
	public Resource toEntity(ResourceRequestDto dto);

}
