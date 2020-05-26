package com.noXML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:sport.properties")
public class SwimCoach implements Coach {

	private FortuneWisher fortuneWisher;
	
	// Literals Using @Value() attribute : Properties file
	@Value("${email}")
	private String email;
	@Value("${name}")
	private String name;	
	
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	
	// *******************************************************************************
	
	public SwimCoach(FortuneWisher fw) {
		this.fortuneWisher = fw;
	}

	@Override
	public String DailyWorkOuts() {
		return "Swim in the Ocean";
	}

	@Override
	public String getFortune() {
		return fortuneWisher.getFortune();
	}

}
