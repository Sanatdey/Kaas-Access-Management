package com.dey.kaas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dey.kaas.entiity.Action;

@Repository
public interface ActionRepository extends CrudRepository<Action, Integer> {

}
