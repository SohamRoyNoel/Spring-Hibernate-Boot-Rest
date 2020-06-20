package com.rest.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.cruddemo.entity.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

}
