package hooks;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.Coach;

public class Hooks {

	public static void main(String[] args) {


		// load configuration file
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from container
		Coach coach = cp.getBean("myCoach", Coach.class);
		System.out.println(coach.DailyWorkOuts());
		// close
		cp.close();

	}
 
}
  