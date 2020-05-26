package com.noXML;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class iocMain {

	public static void main(String[] args) {
		
		// load Spring config java class
		AnnotationConfigApplicationContext cp = new AnnotationConfigApplicationContext(NoXMLConfiguration.class);
		// retrieve bean from container
		Coach coachB = cp.getBean("baseBallCoach", BaseBallCoach.class);
		// call method on bean
		System.out.println(coachB.DailyWorkOuts());

		// now Call the dependent method
		System.out.println("Baseball : " + coachB.getFortune());	
		// close
		cp.close();
	}

}
