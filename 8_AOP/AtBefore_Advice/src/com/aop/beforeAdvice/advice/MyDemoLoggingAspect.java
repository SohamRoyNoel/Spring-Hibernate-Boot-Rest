package com.aop.beforeAdvice.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Before("execution(public void AddAccount())")
	public void beforeAdvice() {
		
		System.err.println("Add befor advice BOOMM!");
		
	}
	
}
