package com.demo.DevToolsDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewRestController {

	@GetMapping("/")
	public String sayhello() {
		return "hello world";
	}
	
	@GetMapping("/lister")
	public String sayList() {
		return "hello world";
	}
	
	
}
