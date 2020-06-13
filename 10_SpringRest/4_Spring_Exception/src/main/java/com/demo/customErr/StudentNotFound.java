package com.demo.customErr;
/*
 * 
 * 
 * CUSTOM EXCEPTION CLASS
 * 
 * 
 * */
public class StudentNotFound extends RuntimeException {

	public StudentNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFound(String message) {
		super(message);
	}

	public StudentNotFound(Throwable cause) {
		super(cause);
	}

	
	
}
