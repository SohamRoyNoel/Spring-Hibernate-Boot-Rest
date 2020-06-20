package com.rest.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeJPAImpl implements EmployeeDAO {

	private EntityManager entitymanager;

	@Autowired
	public EmployeeJPAImpl(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	@Override
	public List<Employee> findAll() {
		// Create Query
		Query query = entitymanager.createQuery("from Employee");
		// Execute Query and Get result
		List<Employee> emps = query.getResultList();
		// Return the results
		return emps;
	}

	@Override
	public Employee findId(int id) {
		
		// Create Query
		Employee query = entitymanager.find(Employee.class, id);

		// Return the results


		return query;
	}

	@Override
	public void save(Employee employee) {
		Employee emps = entitymanager.merge(employee);
		// if id 0 then create else Update
		// for Update with ID in DB
		employee.setId(emps.getId());
	}

	@Override
	public void deleteById(int id) {

		Query query = entitymanager.createQuery("delete from Employee where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

}
