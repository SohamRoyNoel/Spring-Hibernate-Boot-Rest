package com.example.relational.BootRelations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.relational.BootRelations.models.Employee;
import com.example.relational.BootRelations.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.userlist();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable int employeeId) {
		
		Optional<Employee> theEmployee = employeeService.findEmployee(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeBYName(@PathVariable("employeeId") String employeeId) {
		
		Employee theEmployee = employeeService.getEmployeeByName(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee Name not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
				
		theEmployee.setEmp_Id(0);;
		
		employeeService.addEmployee(theEmployee);
		
		return theEmployee;
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.addEmployee(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Optional<Employee> tempEmployee = employeeService.findEmployee(employeeId);
				
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteuser(employeeId);;
		
		return "Deleted employee id - " + employeeId;
	}
}
