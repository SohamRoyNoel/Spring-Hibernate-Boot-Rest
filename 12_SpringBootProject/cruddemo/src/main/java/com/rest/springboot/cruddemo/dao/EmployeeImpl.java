package com.rest.springboot.cruddemo.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeImpl implements EmployeeDAO {
	
	// Define field for Entity Manager
	private EntityManager entityManager;
	
	// Constructor Injection
	@Autowired
	public EmployeeImpl(EntityManager entityManagers) {
		entityManager = entityManagers;
	}



	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// get Current Hibernate Session
		Session currenSession = entityManager.unwrap(Session.class);
		// Create Query
		org.hibernate.query.Query<Employee> query = currenSession.createQuery("from Employee", Employee.class);
		// Execute Query and Get result
		List<Employee> emps = query.getResultList();
		// Return the results
		
		
		return emps;
	}

}
