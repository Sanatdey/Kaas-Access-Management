package com.dey.kaas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dey.kaas.entiity.AccessGroup;

@Repository
public interface AccessGroupRepository extends JpaRepository<AccessGroup, Integer> {

}
