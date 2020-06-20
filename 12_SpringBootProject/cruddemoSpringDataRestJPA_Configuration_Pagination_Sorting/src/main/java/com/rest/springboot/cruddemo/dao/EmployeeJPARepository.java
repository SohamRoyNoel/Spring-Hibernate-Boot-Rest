package com.rest.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.springboot.cruddemo.entity.Employee;

/*
 * Defining Custom path name;
 * instead of Pluralized form of employees 
 * */
@RepositoryRestResource(path="mems") // http://localhost:8080/magic-api/mems
public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

}
