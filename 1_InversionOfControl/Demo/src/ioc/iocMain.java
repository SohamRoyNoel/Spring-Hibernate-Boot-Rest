package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class iocMain {

	public static void main(String[] args) {
		
		// load configuration file
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from container
		Coach coach = cp.getBean("myCoach", Coach.class);
		Coach coachB = cp.getBean("myCoachBaseball", Coach.class);
		// call method on bean
		System.out.println(coach.DailyWorkOuts());
		System.out.println(coachB.DailyWorkOuts());
		// close
		cp.close();
	}

}
