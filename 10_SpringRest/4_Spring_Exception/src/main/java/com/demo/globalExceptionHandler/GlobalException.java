package com.demo.globalExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.customErr.StudentErrorResponse;
import com.demo.customErr.StudentNotFound;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler
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
	}
	
}
