package com.rest.springboot.cruddemo.dao;

import java.util.List;

import com.rest.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
