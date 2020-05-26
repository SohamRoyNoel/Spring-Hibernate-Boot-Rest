package com.main.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.depencency.*;

@Component
public class AnnotationCoach implements Coach {
	/*
	 * Field Injection : pass the field only no setter or constructor required
	 * */
	@Autowired
	private FortuneWisher fortuneWisher;

	// --------------------------------------------------------------------------------------------------------------
	/*
	 * Checks all the classes who implements Fortune wisher
	 * */
	/*
	 * 
	 * Method Injection : can INJECT ANY METHOD, using @AutoWired
	 * That must use FortuneWiser
	 * 
	 * 
	public AnnotationCoach() {}

	@Autowired
	public void methodInjectionDemo(FortuneWisher fw) {
		System.out.println("Method Injection");
		this.fortuneWisher = fw;
	}*/ 	

	/*
	 * 
	 * Setter Injection
	 * 
	// --------------------------------------------------------------------------------------------------------------

	@Autowired
	public void setFortuneWisher(FortuneWisher fortuneWisher) {
		this.fortuneWisher = fortuneWisher;
		System.out.println("Fortune wisher Setter Injection : " + fortuneWisher);
	}*/


	// -------------------------------------------------------------------------------------------------------------- 
	/*
	 * 
	 * Constructor INJECTION
	 * 
	@Autowired
	public AnnotationCoach(FortuneWisher fw) {
		fortuneWisher = fw;
	}*/



	@Override
	public String DailyWorkOuts() {
		return "WorkOut Daily you fatty dumb";
	}

	@Override
	public String getFortune() {
		return fortuneWisher.getFortune();
	}

}
