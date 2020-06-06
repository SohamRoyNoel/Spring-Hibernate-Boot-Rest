package com.aop.beforeAdvice.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	/*
	 * PointCut :
	 * 
	 * execution(public void AddAccount()) : A predicate application where advice should be applied
	 * 
	 * */
	
	//@Before("execution(public void AddAccount())") // applies before any method named AddAccount()
	
	// applies before any method named AccountDAO.AddAccount() not MembershipDAO.AddAccount() 
	
	@Before("execution(public void com.aop.beforeAdvice.dao.AccountDAO.AddAccount())")
	/*
	 * Add befor advice BOOMM!
		Trigerable Method : class com.aop.beforeAdvice.dao.AccountDAO
		Trigerable Member Method : class com.aop.beforeAdvice.dao.MembershipDAO
	 * */
	//@Before("execution(* Add*())") // WildCard
	/*Add befor advice BOOMM!
		Add befor advice BOOMM!
		Trigerable Method : class com.aop.beforeAdvice.dao.AccountDAO
		Trigerable Member Method : class com.aop.beforeAdvice.dao.MembershipDAO
	 * */
	public void beforeAdvice() {
		
		System.err.println("Add befor advice BOOMM!");
		
	}
	
}
