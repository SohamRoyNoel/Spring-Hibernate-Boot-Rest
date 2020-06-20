package com.rest.springboot.cruddemo.service;

import java.util.List;

import com.rest.springboot.cruddemo.entity.Employee;


public interface EmployeeService {

	public List<Employee> findAll();
	// Get By Id
	public Employee findId(int id);
	// save
	public void save(Employee employee);
	// delete
	public void deleteById(int id);
	
}
