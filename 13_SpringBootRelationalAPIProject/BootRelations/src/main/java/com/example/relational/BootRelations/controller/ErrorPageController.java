package com.example.relational.BootRelations.controller;

import java.nio.file.Path;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ErrorPageController implements ErrorController {
	
	private static final String Path = "/error";

	@Override
	public String getErrorPath() {
		return Path;
	}

	@RequestMapping("/error")
	public String errorCasehandler() {
		return "No Mappings Found";
	}
}
