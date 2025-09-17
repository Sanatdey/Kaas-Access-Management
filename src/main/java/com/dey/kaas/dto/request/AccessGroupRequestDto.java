package com.dey.kaas.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record AccessGroupRequestDto(
		
		@NotBlank(message="Access group name Cannot be Blank!")
		String name,
		@NotBlank(message="Access list Cannot be Blank!")
		List<Integer> accessIds
		
		) {}
