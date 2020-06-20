package com.demo.DevToolsDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewRestController {
	
	@Value("${coachname}")
	private String coachName;
	
	@Value("${coachAge}")
	private String coachAge;

	@GetMapping("/")
	public String sayhello() {
		return "hello world";
	}
	
	@GetMapping("/lister")
	public String sayList() {
		return coachName + " "+ coachAge;
	}
	
	@GetMapping("/appProp")
	public String ApplicationPropertyReader() {
		return "hello world";
	}
}
