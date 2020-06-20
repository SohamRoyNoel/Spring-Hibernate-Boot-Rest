package com.rest.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.springboot.cruddemo.dao.EmployeeDAO;
import com.rest.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;

	/*
	 * Use @Qualifier when you have multiple number of Repositories;
	 * It helps Spring to map A service with a repository
	 * 
	 * Qualifier name must be IN SMALL LETTER 
	 * EX: EmployeeJPAImpl to employeeJPAImpl (it creates a bean like this way)
	 * 
	 * */
	// Const Injection
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeJPAImpl") EmployeeDAO employeeDAOs) {
		employeeDAO = employeeDAOs;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findId(int id) {
		return employeeDAO.findId(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}
