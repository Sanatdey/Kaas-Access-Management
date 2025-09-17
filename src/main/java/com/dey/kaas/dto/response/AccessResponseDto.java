package com.dey.kaas.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record AccessResponseDto(
		Integer id,
		String name,
		ResourceResponseDto resource,
		List<ActionResponseDto> action,
		LocalDateTime created_at,
		LocalDateTime updated_at
		) {}
