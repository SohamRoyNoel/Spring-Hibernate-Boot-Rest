package com.springMVC.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springMVC.hibernate.dao.CustomerDAO;
import com.springMVC.hibernate.models.Customer;
/*
 * Service belong in between DAO and CONTROLLER
 * Allows A controller to get data from Multiple Other DAOs
 * 
 * */
@Service
public class CustomerServiceIMPL implements CustomerService {

	// Inject dependency
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void SaveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}


	@Override
	@Transactional
	public Customer getCustomer(int uid) {
		// Get The uSer by ID from DAO
		return customerDAO.getCustomers(uid);
	}

}
