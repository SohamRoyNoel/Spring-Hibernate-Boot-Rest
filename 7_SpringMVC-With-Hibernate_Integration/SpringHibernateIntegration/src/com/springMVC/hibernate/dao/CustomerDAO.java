package com.springMVC.hibernate.dao;

import java.util.List;

import com.springMVC.hibernate.models.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
}
