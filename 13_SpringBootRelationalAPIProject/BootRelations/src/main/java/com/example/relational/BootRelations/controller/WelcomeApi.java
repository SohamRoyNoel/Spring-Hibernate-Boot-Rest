package com.example.relational.BootRelations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeApi {

	@GetMapping("/")
	public String welcomepage() {
		return "index";
	}
	
}
