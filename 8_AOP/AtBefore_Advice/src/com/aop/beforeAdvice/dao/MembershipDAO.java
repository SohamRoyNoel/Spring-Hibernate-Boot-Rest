package com.aop.beforeAdvice.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void AddAccount() {
		System.out.println("Trigerable Member Method : " + getClass());
	}
	
}
