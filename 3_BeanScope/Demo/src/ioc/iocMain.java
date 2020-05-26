package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class iocMain {

	public static void main(String[] args) {
		
		// load configuration file
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from container
		Coach coachB = cp.getBean("myCoachBaseball", BaseBallCoach.class);
		// call method on bean
		System.out.println(coachB.DailyWorkOuts());

		// now Call the dependent method
		System.out.println("Baseball : " + coachB.getFortune());	
		// close
		cp.close();
	}

}
