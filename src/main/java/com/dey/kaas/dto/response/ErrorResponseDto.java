package com.dey.kaas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDto {
	
	private int status = 0;
	private String mesage;
	private Object data;
	

}

