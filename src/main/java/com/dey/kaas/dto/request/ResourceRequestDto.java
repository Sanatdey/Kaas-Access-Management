package com.dey.kaas.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ResourceRequestDto(
		
		@NotBlank(message="Resource name Cannot be Blank!")
		String name,
		@NotBlank(message="Resource Type Cannot be Blank!")
		Integer typeId
		
		) {}
