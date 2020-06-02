package com.springMVC.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springMVC.hibernate.dao.CustomerDAO;
import com.springMVC.hibernate.models.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Inject DAO to controller : spring is goinf to scan all classes that implements "CustomerDAO"
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/list")
	public String listNames(Model listModel) {
		
		// get customer from dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// add customer to the model
		listModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}

}
