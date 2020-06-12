package com.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomLoginPageController {

	@GetMapping("/showMyLoginPage")
	public String returnCustomLoginView() {
		System.out.println("hello");
		return "login-form";
	}
	
}
