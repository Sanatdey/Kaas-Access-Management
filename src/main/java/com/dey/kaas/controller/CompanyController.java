package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dey.kaas.dto.request.CompanyRequestDto;
import com.dey.kaas.service.CompanyService;

@RestController
public class CompanyController {
	
	CompanyService companyService;
	
	public CompanyController(CompanyService companyService){
		this.companyService = companyService;
	}
	
	
	@GetMapping("/companies")
	public ResponseEntity<?> getAllCompanies() {
		return companyService.getAllCompany();
	}
	
	@PostMapping("/companies")
	public ResponseEntity<?> addCompany(@RequestBody CompanyRequestDto dto) {
		return companyService.addCompany(dto);
	}


}
