package com.dey.kaas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/companies/{id}")
    public ResponseEntity<?> updateCompanies(@PathVariable int id, @RequestBody CompanyRequestDto dto) {
        return companyService.updateCompany(id, dto);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?> addCompany(@PathVariable int id) {
        return companyService.deleteCompany(id);
    }

}
