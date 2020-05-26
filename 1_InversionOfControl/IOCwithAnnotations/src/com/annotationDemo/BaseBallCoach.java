package com.annotationDemo;

import org.springframework.stereotype.Component;

@Component("MyDuckingBEAN")
public class BaseBallCoach implements Coach{

	@Override
	public String DailyWorkOuts() {
		return "Practice Ball ball Now";
	}

	
	
}
