package com.example.relational.BootRelations.services;

import java.util.List;
import java.util.Optional;

import com.example.relational.BootRelations.models.Employee;

public interface EmployeeService {

	List<Employee> userlist();
	
	Optional<Employee> findEmployee(int id);
	
	Employee addEmployee(Employee emps);
	
	void deleteuser(int id);
	
	Employee getEmployeeByName(String emp);
	
}
