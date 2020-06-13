package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demo.model.Student;

@RestController
@EnableWebMvc
@RequestMapping("/student")
public class StudentRestControllerParameter {
	
	List<Student> lister;
	
	//use @PostContruct  to load Student data once only
	@PostConstruct
	public void loadData() {
		lister = new ArrayList<Student>();
		lister.add(new Student("Pom", "Pee"));
		lister.add(new Student("Pojo", "Pi"));
		lister.add(new Student("Pipi", "Pipo"));
	}

	@GetMapping("/stuId/{theid}")
	public Student showStudents(@PathVariable int theid){
		
		return lister.get(theid);
		
	}
	
}
