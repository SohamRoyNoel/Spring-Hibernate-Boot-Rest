package com.rest.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.cruddemo.dao.EmployeeDAO;
import com.rest.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDAO empDao;

	// Constructor Injection
	@Autowired
	public EmployeeRestController(EmployeeDAO empDao) {
		super();
		this.empDao = empDao;
	}
	
	@GetMapping("/fetchEmployee")
	public List<Employee> getList(){
		return empDao.findAll();
	}
}
