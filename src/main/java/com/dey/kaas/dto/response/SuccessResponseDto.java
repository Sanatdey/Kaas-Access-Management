package com.dey.kaas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SuccessResponseDto {
	
	private int status;
	private String mesage;
	private Object data;

}
