package com.aop.beforeAdvice.dao;

import org.springframework.stereotype.Component;

import com.aop.beforeAdvice.models.Account;

@Component
public class AccountDAO {

	public void AddAccount(Account account, String a, String b) {
		System.out.println("Trigerable Method : " + getClass());
	}
	
}
