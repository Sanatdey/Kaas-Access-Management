package com.dey.kaas.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ResourceTypeRequestDto(
		
		@NotBlank(message="Resource Type name Cannot be Blank!")
		String name,
		@NotBlank(message="Company Cannot be Blank!")
		Integer companyId
		
		) {}
