package com.dey.kaas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dey.kaas.entiity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
