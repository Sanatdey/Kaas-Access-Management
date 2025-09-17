package com.dey.kaas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dey.kaas.dto.request.ResourceTypeRequestDto;
import com.dey.kaas.dto.response.ResourceTypeResponseDto;
import com.dey.kaas.entiity.ResourceType;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface ResourceTypeMapper {
	
	public ResourceTypeResponseDto toDto(ResourceType type);
	
	@Mapping(target="company",ignore=true)
	public ResourceType toEntity(ResourceTypeRequestDto dto);

}
