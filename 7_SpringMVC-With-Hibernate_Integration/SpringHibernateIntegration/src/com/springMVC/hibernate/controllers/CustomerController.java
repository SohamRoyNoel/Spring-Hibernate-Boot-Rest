package com.springMVC.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springMVC.hibernate.dao.CustomerDAO;
import com.springMVC.hibernate.models.Customer;
import com.springMVC.hibernate.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	 * WHILE NOT USING SERVICE
	 * 
	 * // Inject DAO to controller : spring is goinf to scan all classes that implements "CustomerDAO"
	@Autowired
	private CustomerDAO customerDAO;*/
	
	
	// NEED TO INJECT SERVICE
	@Autowired
	private CustomerService customerService;
	
	
//	@RequestMapping("/list") // Universal case
//	@RequestMapping(path = "/list", method = RequestMethod.GET)
	@GetMapping("/list") // handles only get request
	public String listNames(Model listModel) {
		// get customer from dao
		List<Customer> theCustomers = customerService.getCustomers();
		// add customer to the model
		listModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormToAddCustomer")
	public String showFormToAddCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("addCustomer", customer);
		return "customaer-add";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("saveCustomer") Customer customer) {
		
		// Create the customer
		customerService.SaveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int uid, Model model) {
		// Get Customer from Service
		Customer theCustomer = customerService.getCustomer(uid);
		
		// Set customer as a modal attribute to pre populate data
		/*
		 * This should always be the same :::>
		 * <form:form action="saveCustomer" modelAttribute="addCustomer" method="POST"> on customaer-add.jsp page
		 * 
		 * this way it will pre populate data on basis of the path
		 * 
		 * */
		model.addAttribute("addCustomer", theCustomer);
		
		// send to Form
		return "customaer-add";
	}

}
