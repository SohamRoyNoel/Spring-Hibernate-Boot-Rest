package com.aop.beforeAdvice.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void AddAccount() {
		System.out.println("Trigerable Method : " + getClass());
	}
	
}
