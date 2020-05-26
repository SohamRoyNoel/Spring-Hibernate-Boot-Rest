package com.demos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * if there is multiple method with same @RequestMapping
 * Then code will crash; by the conflict,
 * so its always good to set some PARENT Level Request Mapping
 * */
@Controller
@RequestMapping("/ambigious")
public class AmbigiousMappingController {

	@RequestMapping("/processform")
	public String getPage() {
		return "show-menu";
	}
	
}
