package com.dey.kaas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dey.kaas.entiity.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
