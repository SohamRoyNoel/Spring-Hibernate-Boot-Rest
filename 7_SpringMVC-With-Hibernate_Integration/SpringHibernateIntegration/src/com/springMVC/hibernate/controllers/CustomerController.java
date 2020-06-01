package com.springMVC.hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/")
	public String cover() {
		return "home";
	}
	
	
	@RequestMapping("/list")
	public String listNames(Model listModel) {
		return "list-customers";
	}

}
