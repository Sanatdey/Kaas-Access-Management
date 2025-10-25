package com.dey.kaas.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.dey.kaas.entiity.Access;
import com.dey.kaas.entiity.AccessGroup;

public record UserResponseDto(
		
		String firstName,
		String lastName,
		String email,
		String phoneNumber,
		CompanyResponseDto company,
        String role,
		List<AccessGroupResponseDto> accessgroups,
		List<AccessResponseDto> accesses,
		LocalDateTime created_at,
        LocalDateTime updated_at
		) {}
