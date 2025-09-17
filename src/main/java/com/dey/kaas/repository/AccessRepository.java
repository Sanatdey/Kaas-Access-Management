package com.dey.kaas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dey.kaas.entiity.Access;

@Repository
public interface AccessRepository extends JpaRepository<Access, Integer> {

}
