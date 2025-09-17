package com.dey.kaas.dto.response;

import java.time.LocalDateTime;

public record CompanyResponseDto(
		int id,
		String name,
		String gstNumber,
		LocalDateTime created_at,
		LocalDateTime updated_at
		) {

}
