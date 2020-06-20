package com.rest.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.springboot.cruddemo.dao.EmployeeJPARepository;
import com.rest.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeJPARepository employeeJPARepository;

	/*
	 * SpringData JPA has Only a Repo, thats all
	 * Transactional is Useless here
	 * 
	 * */
	// Const Injection
	@Autowired
	public EmployeeServiceImpl(EmployeeJPARepository employeeJPARepositorys) {
		employeeJPARepository = employeeJPARepositorys;
	}

	@Override
	public List<Employee> findAll() {
		return employeeJPARepository.findAll();
	}

	@Override
	public Employee findId(int id) {
		/*
		 * Instead of checking for nulls use Optional
		 * Returns TRUE or False
		 * */
		Optional<Employee> result = employeeJPARepository.findById(id);
		
		Employee employees = null;
		
		if(result.isPresent()) {
			employees = result.get();
		}
		
		
		return employees;
	}

	@Override
	public void save(Employee employee) {
		employeeJPARepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeJPARepository.deleteById(id);
	}

}
