package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.InstructorDetails;
import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;

public class CreateInstructorWithCourse {

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

			System.out.println("instructor : " + tempInstructor);

			System.out.println("Courses : " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
