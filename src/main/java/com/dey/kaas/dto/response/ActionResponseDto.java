package com.dey.kaas.dto.response;

import java.time.LocalDateTime;

public record ActionResponseDto(
		Integer id,
		String name,
		LocalDateTime created_at,
		LocalDateTime updated_at
		) {}
