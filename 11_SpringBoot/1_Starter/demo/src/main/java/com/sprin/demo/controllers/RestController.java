package com.sprin.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String sayhello() {
		return "hello world";
	}
	
}
