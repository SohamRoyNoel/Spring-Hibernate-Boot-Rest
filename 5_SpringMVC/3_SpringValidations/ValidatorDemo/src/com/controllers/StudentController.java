package com.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.models.Students;
/*
 * 
 * USING MODEL ATTRIBUTE
 * 
 * */
@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/show")
	public String showForm(Model theStudentModel) {

		// Create a Student model Object
		Students students = new Students();

		// Add Student Object  to the model
		theStudentModel.addAttribute("students", students);

		return "show-form";
	}

	/*
	 * <form:form action="processForm" modelAttribute="student">
	 * modelAttribute name should be same as @ModelAttribute("students")
	 * */
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("students") Students stu, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "show-form";
		}else {
			return "show-conferm";
		}
	}

}
