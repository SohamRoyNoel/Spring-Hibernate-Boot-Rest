package com.springMVC.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springMVC.hibernate.models.Customer;

@Repository // Component Scan
public class CustomerDAOIMPL implements CustomerDAO {

	// Inject Hibernate session factory
	/*
	 * sessionFactory <===================> this name should be similar with ****bean id****
	 * <bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
	 * */
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional // hibernate manages sessions automatically
	public List<Customer> getCustomers() {
		
		// get current Hibernate Session
		Session currSession = sessionFactory.getCurrentSession();
		// create Query
		Query<Customer> getList = currSession.createQuery("from Customer", Customer.class);
		// execute query and get result list
		List<Customer> customers = getList.getResultList();
		// return result
		return customers;
	}

}
