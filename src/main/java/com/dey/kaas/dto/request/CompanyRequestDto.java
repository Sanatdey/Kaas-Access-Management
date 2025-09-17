package com.dey.kaas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CompanyRequestDto(
		
		@NotBlank(message="Name of your company cannot be blank!")
		@Size(max = 200 , min = 3 , message = "Name of your company should be in 3 to 200 character!")
		String name,
		
		@NotBlank(message="getNumber of your company cannot be blank!")
		@Size(max = 15 , min = 3 , message = "GST Number of your company should be in 15 character!")
		String gstNumber
		
		) {}
