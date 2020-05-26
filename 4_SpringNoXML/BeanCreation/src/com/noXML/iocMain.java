package com.noXML;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class iocMain {

	public static void main(String[] args) {

		// load Spring config java class
		AnnotationConfigApplicationContext cp = new AnnotationConfigApplicationContext(NoXMLConfiguration.class);
		// retrieve bean from container
		
		// Coach coachB = cp.getBean("swimer", SwimCoach.class);
		/*
		 * Swim in the Ocean
		 * LUCK : You look Dandy
		 * 
		 * */
		Coach coachB = cp.getBean("swimer1", SwimCoach.class); // use method name; as that is the BEAN ID
		
		/*
		 * Swim in the Ocean
         * LUCK : Good luck my boy
		 * 
		 * */
		// call method on bean
		System.out.println(coachB.DailyWorkOuts());

		// now Call the dependent method
		System.out.println("LUCK : " + coachB.getFortune());	
		
		// Literal Properties :> 
		/*
		 * We have to instantiate SwimCoach as getter method
		 * belongs to child class SwimCoach not on the parent Class
		 * */
		SwimCoach literals = cp.getBean("swimer1", SwimCoach.class);
		
		System.out.println("email : " + literals.getEmail() + " Name : "+ literals.getName());
		// email : swimer@gmail.com Name : swimer1
		
		
		// close
		cp.close();
	}

}
