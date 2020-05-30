package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.InstructorDetails;
import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;

public class CreateCourse {

	public static void main(String[] args) {

		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(One2Many_Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(One2Many_Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {	

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			One2Many_Instructor tempInstructor = session.get(One2Many_Instructor.class, theId);		

			// create some courses
			One2Many_Course tempCourse1 = new One2Many_Course("Air Guitar - The Ultimate Guide");
			One2Many_Course tempCourse2 = new One2Many_Course("The Pinball Masterclass");

			// add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
