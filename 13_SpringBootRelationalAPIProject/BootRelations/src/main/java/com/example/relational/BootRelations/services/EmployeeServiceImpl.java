package com.example.relational.BootRelations.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.example.relational.BootRelations.models.Employee;
import com.example.relational.BootRelations.repository.DesignationRepository;
import com.example.relational.BootRelations.repository.EmployeeRepository;

@Service
//@EnableJpaRepositories(basePackages = { "com.example.relational.BootRelations" })
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	private DesignationRepository designationRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DesignationRepository designationRepository) {
		this.employeeRepository = employeeRepository;
		this.designationRepository = designationRepository;
	}



	@Override
	public List<Employee> userlist() {		
		return employeeRepository.findAll();
	}



	@Override
	public Optional<Employee> findEmployee(int id) {
		return employeeRepository.findById(id);
	}



	@Override
	public Employee addEmployee(Employee emps) {
		emps.setDesignation(designationRepository.getOne(emps.getDesignation_Id()));
		return employeeRepository.save(emps);
	}



	@Override
	public void deleteuser(int id) {
		employeeRepository.deleteById(id);
	}



	@Override
	public Employee getEmployeeByName(String emp) {
		return employeeRepository.findByname(emp);
	}

	
}
