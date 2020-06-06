package com.aop.beforeAdvice.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.beforeAdvice.dao.AccountDAO;
import com.aop.beforeAdvice.dao.MembershipDAO;
import com.aop.beforeAdvice.models.Account;

public class Main {

	public static void main(String[] args) {

		// Read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		Account acc = new Account();
		
		// get the bean from container
		AccountDAO acd = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO mem = context.getBean("membershipDAO", MembershipDAO.class);
		// call method
		acd.AddAccount(acc, "a", "b");
		mem.AddAccount();
		
		context.close();
		
	}

}
