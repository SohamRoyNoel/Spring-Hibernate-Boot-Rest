package BeanScope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.BaseBallCoach;
import ioc.Coach;

public class Beanscope {

	public static void main(String[] args) {


		// load configuration file
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from container
		Coach coach = cp.getBean("myCoach", Coach.class);
		Coach coachB = cp.getBean("myCoach", Coach.class);
		// Check if they are same
		boolean b = (coach == coachB);
		System.out.println("Checker : " + b);
		System.out.println("Coach : " + coach);
		System.out.println("Coach : " + coachB);
		// close
		cp.close();

	}

}
  