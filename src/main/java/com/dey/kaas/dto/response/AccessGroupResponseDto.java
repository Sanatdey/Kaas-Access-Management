package com.dey.kaas.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record AccessGroupResponseDto(
		Integer id,
		String name,
		List<AccessResponseDto> accesses,
		LocalDateTime created_at,
		LocalDateTime updated_at
		) {}
