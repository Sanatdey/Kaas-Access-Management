package com.dey.kaas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dey.kaas.dto.request.UserRequestDto;
import com.dey.kaas.dto.response.UserResponseDto;
import com.dey.kaas.entiity.User;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, AccessMapper.class, AccessGroupMapper.class})
public interface UserMapper {
	
	UserResponseDto toDto(User user);
	
	@Mapping(target = "company", ignore = true)
	@Mapping(target = "accesses", ignore = true)
	@Mapping(target = "accessgroups", ignore = true)
	User toEntity(UserRequestDto dto);
	
}
