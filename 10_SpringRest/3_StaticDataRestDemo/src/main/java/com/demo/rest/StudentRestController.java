package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demo.model.Student;

@RestController
@EnableWebMvc
@RequestMapping("/student")
public class StudentRestController {

	@GetMapping("/hello")
	public List<Student> showStudents(){
		
		List<Student> lister = new ArrayList<Student>();
		lister.add(new Student("Pom", "Pee"));
		lister.add(new Student("Pojo", "Pi"));
		lister.add(new Student("Pipi", "Pipo"));
		
		return lister;
	}
	
}
