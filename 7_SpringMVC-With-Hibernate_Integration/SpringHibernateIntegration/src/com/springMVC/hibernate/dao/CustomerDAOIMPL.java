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
	//@Transactional // hibernate manages sessions automatically ==============>When Using SERVICE
	public List<Customer> getCustomers() {
		
		// get current Hibernate Session
		Session currSession = sessionFactory.getCurrentSession();
		// create Query
		Query<Customer> getList = currSession.createQuery("from Customer order by last_name", Customer.class);
		// execute query and get result list
		List<Customer> customers = getList.getResultList();
		// return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSreesion = sessionFactory.getCurrentSession();
		/*
		 * To INSERT A FIELD
		 * */
		// currentSreesion.save(customer);
		/*
		 * In case of update we use saveOrUpdate
		 * 
		 * Behind the scene hibernate determines; if it has ID, then UPDATE else INSERT
		 * 
		 * */
		currentSreesion.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomers(int uid) {

		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, uid);
		
		return customer;
	}

}
