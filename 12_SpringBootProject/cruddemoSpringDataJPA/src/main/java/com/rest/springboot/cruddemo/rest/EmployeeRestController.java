package com.rest.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.cruddemo.entity.Employee;
import com.rest.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//private EmployeeDAO empDao;

	private EmployeeService employeeService;

	// Constructor Injection
	@Autowired
	public EmployeeRestController(EmployeeService employeeServices) {
		employeeService = employeeServices;
	}

	@GetMapping("/fetchEmployee")
	public List<Employee> getList(){
		return employeeService.findAll();
	}

	@GetMapping("/fetchEmployee/{empId}")
	public Employee getSingular(@PathVariable int empId){

		Employee emp = employeeService.findId(empId);
		if(emp == null) {
			throw new RuntimeException("No employee found");
		}
		return emp;
	}

	@PostMapping("/saveEmployee")
	public Employee saveSingular(@RequestBody Employee emps){
		// set 0 -> if the request is in json it forces the saveOrUpdate() to save rather update
		emps.setId(0);
		employeeService.save(emps);
		return emps;
	}
	
	@PutMapping("/saveEmployees")
	public Employee updateSingular(@RequestBody Employee emps){
		// set 0 -> if the request is in json it forces the saveOrUpdate() to save rather update
		employeeService.save(emps);
		return emps;
	}
	
	@DeleteMapping("/delEmployees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findId(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
}
