package com.dey.kaas.controller;

import com.dey.kaas.dto.response.SuccessResponseDto;
import com.dey.kaas.exeption.AccessOrAccessGroupNotFoundException;
import com.dey.kaas.exeption.CompanyNotFoundException;
import com.dey.kaas.exeption.InvalidUsernameOrPasswordException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AccessOrAccessGroupNotFoundException.class)
    public ResponseEntity<?>  accessNotFoundException(){
        return new ResponseEntity<>(new SuccessResponseDto(404 , "access group or access not found", null),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<?>  companyNotFoundException(){
        return new ResponseEntity<>(new SuccessResponseDto(404 , "company not found", null),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidUsernameOrPasswordException.class)
    public ResponseEntity<?>  loginException(){
        return ResponseEntity.badRequest().body(new SuccessResponseDto(400 , "Invalid Username or Password", null));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?>  lilligalException(){
        return ResponseEntity.badRequest().body(new SuccessResponseDto(400 , "Invalid value , please check the documentation", null));
    }
}
