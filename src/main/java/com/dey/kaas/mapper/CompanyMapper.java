package com.dey.kaas.mapper;

import org.mapstruct.Mapper;

import com.dey.kaas.dto.request.CompanyRequestDto;
import com.dey.kaas.dto.response.CompanyResponseDto;
import com.dey.kaas.entiity.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	CompanyResponseDto toDto(Company company);
	Company toEntity(CompanyRequestDto dto);
}
