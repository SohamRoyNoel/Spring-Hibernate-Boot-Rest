package com.rest.springboot.cruddemo.dao;

import java.util.List;

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

	@Override
	public Employee findId(int id) {
		// get Current Hibernate Session
		Session currenSession = entityManager.unwrap(Session.class);
		// Create Query
		Employee query = currenSession.get(Employee.class, id);
		
		// Return the results


		return query;
	}

	@Override
	public void save(Employee employee) {
		
		Session currenSession = entityManager.unwrap(Session.class);
		currenSession.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		Session currenSession = entityManager.unwrap(Session.class);
		org.hibernate.query.Query<Employee> query = currenSession.createQuery("delete from Employee where Id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
