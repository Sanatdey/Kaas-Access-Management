package com.dey.kaas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dey.kaas.entiity.ResourceType;

@Repository
public interface ResourceTypeRepository extends CrudRepository<ResourceType, Integer> {

}
