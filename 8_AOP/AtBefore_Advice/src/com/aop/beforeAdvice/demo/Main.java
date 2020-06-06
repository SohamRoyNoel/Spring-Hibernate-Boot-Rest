package com.aop.beforeAdvice.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.beforeAdvice.dao.AccountDAO;

public class Main {

	public static void main(String[] args) {

		// Read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from container
		AccountDAO acd = context.getBean("accountDAO", AccountDAO.class);
		
		// call method
		acd.AddAccount();
		
		context.close();
		
	}

}
