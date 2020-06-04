package com.springMVC.hibernate.services;

import java.util.List;

import com.springMVC.hibernate.models.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomers();

	public void SaveCustomer(Customer customer);

	public Customer getCustomer(int uid);

	public void delCustomer(int uid);
	
}
