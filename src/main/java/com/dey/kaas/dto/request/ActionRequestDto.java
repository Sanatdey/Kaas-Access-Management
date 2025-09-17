package com.dey.kaas.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ActionRequestDto(
		
		@NotBlank(message="Action Type name Cannot be Blank!")
		String name
		) {}
