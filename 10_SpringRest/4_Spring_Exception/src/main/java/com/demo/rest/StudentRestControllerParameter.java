package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demo.customErr.StudentErrorResponse;
import com.demo.customErr.StudentNotFound;
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
		/*
		 * 
		 * 3. PROVIDE LOGIC TO THROW EXCEPTION
		 * 
		 * */
		if( (theid >= lister.size()) || theid < 0 ) {
			throw new StudentNotFound("Student Id Not Found");
		}
		
		return lister.get(theid);
		
	}
	/*
	 * 
	 *	IN REAL LIFE ITS HARD TO USE INDEVIDUAL EXCEPTION HANDLER SO THAT 
	 *	any class will use the same Exception 
	 * 
	 * 
	 * 	BY making GLOBAL Exception Handler by @ControllerAdvice
	 * 
	 *  Use OF AOP
	 * 
	 * */
	
	
	
	
	/*
	 * 
	 * 
	 * 4.CREATE the RESPONSE Entity
	 * 
	 * 
	 * */
	/*@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handelException(StudentNotFound s){
		
		// Create A studentErr response
		StudentErrorResponse stu = new StudentErrorResponse();
		stu.setStatus(HttpStatus.NOT_FOUND.value());
		stu.setMessage(s.getMessage());
		stu.setTimestamp(System.currentTimeMillis());
		
		
		// Return Response Entity
		return new ResponseEntity<StudentErrorResponse>(stu, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handelDefaultException(Exception s){
		
		// Create A studentErr response
		StudentErrorResponse stu = new StudentErrorResponse();
		stu.setStatus(HttpStatus.BAD_REQUEST.value());
		stu.setMessage(s.getMessage());
		stu.setTimestamp(System.currentTimeMillis());
		
		
		// Return Response Entity
		return new ResponseEntity<StudentErrorResponse>(stu, HttpStatus.BAD_REQUEST);
	}*/
}
