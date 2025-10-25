package com.dey.kaas.service;

import java.util.List;

import com.dey.kaas.dto.request.ActionRequestDto;
import com.dey.kaas.entiity.Action;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dey.kaas.dto.request.CompanyRequestDto;
import com.dey.kaas.entiity.Company;
import com.dey.kaas.exeption.CompanyNotFoundException;
import com.dey.kaas.mapper.CompanyMapper;
import com.dey.kaas.repository.CompanyRepository;

@Service
public class CompanyService {
	
	CompanyRepository companyRepository;
	CompanyMapper mapper;
	public CompanyService(CompanyRepository companyRepository , CompanyMapper mapper) {
		this.companyRepository = companyRepository;
		this.mapper = mapper;
	}
	
	
	public ResponseEntity<List<?>> getAllCompany() {
		return ResponseEntity.ok().body(companyRepository.findAll());
	}
	
	public ResponseEntity<Company> addCompany(CompanyRequestDto dto) {
		Company c = mapper.toEntity(dto);
		return ResponseEntity.ok().body(companyRepository.save(c));
	}


	public Company getCompany(Integer companyId) {
		return companyRepository.findById(companyId).orElseThrow( () ->  new CompanyNotFoundException("exp") );
	}

    public ResponseEntity<Company> updateCompany(int id, CompanyRequestDto dto) {
        Company company = getCompany(id);
        Company c = mapper.toEntity(dto);
        company.setName(c.getName());
        company.setGstNumber(c.getGstNumber());
        return ResponseEntity.ok().body(companyRepository.save(company));
    }

    public ResponseEntity<?> deleteCompany(int id) {
        Company company = getCompany(id);
        companyRepository.delete(company);
        return ResponseEntity.ok().build();
    }

}
