package com.dey.kaas.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record AccessRequestDto(
		
		@NotBlank(message="Action name Cannot be Blank!")
		String name,
		@NotBlank(message="Resource Cannot be Blank!")
		Integer resourceId,
		@NotBlank(message="Action Cannot be Blank!")
		List<Integer> actionId
		
		) {}
