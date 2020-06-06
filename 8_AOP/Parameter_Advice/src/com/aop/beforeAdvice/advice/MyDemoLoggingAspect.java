package com.aop.beforeAdvice.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	/*Passing A Parameter (Qualified name is important)*/

	//@Before("execution(* Add*(com.aop.beforeAdvice.models.Account))")
	
	/*For n number of parameters*/
	//@Before("execution(* Add*(..))")
	/*
	Add befor advice BOOMM!
	Add befor advice BOOMM!
	Trigerable Method : class com.aop.beforeAdvice.dao.AccountDAO
	Trigerable Member Method : class com.aop.beforeAdvice.dao.MembershipDAO
	*/
	
	// com.aop.beforeAdvice.models.Account parameter is mandatory
	//@Before("execution(* Add*(com.aop.beforeAdvice.models.Account, ..))")
	/*Add befor advice BOOMM!
	Trigerable Method : class com.aop.beforeAdvice.dao.AccountDAO
	Trigerable Member Method : class com.aop.beforeAdvice.dao.MembershipDAO*/
	
	/*
	 * Applying For Specified Package
	 * */
	//        ReturnType(*)   PACKAGE(com.aop.beforeAdvice.dao)   Class(*) Method(*) Params(..) 
	@Before("execution(* com.aop.beforeAdvice.dao.*.*(..))")
	public void beforeAdvice() {
		
		System.err.println("Add befor advice BOOMM!");
		
	}
	
}
