package com.dey.kaas.dto.request;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
		@NotBlank(message="First name Cannot be Blank!")
		String firstName,
		
		String lastName,
		
		@NotBlank(message="Email Cannot be Blank!")
		@Email(message="Email is not in Correct Format")
		String email,
		
		@NotBlank(message="Phone Number Cannot be Blank!")
		@Size(min=9 , max=12 , message="Please give 9-12 digit phone number")
		String phoneNumber,
		
		@NotBlank(message="Phone Number Cannot be Blank!")
		Integer companyId,
		
		@NotBlank(message="Password Cannot be Blank!")
		@Size(min=8 , max=50 , message="Please give more then 8 character password")
		String password,

        @NotBlank(message = "Role of the User Cannot be Blank")
        Integer role,
		
		List<Integer> accessIds,

		List<Integer> accessGroupIds
		
		
		){}
