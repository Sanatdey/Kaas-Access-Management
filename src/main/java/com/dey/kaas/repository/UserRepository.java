package com.dey.kaas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dey.kaas.entiity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
