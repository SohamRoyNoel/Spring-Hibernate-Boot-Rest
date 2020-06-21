package com.rest.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.springboot.cruddemo.entity.TestScenarioMaster;

@RepositoryRestResource(collectionResourceRel = "tcs", path = "TestScenarioMaster")
public interface TestScenarioMasterJPARepository extends JpaRepository<TestScenarioMaster, Integer> {

}
