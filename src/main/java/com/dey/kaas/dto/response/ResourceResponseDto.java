package com.dey.kaas.dto.response;

import java.time.LocalDateTime;

public record ResourceResponseDto(
		int id,
		String name,
		ResourceTypeResponseDto type,
		LocalDateTime created_at,
		LocalDateTime updated_at
		) {

}
