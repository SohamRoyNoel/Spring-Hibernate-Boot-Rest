package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Instructor;
import com.jdbc.models.InstructorDetails;

public class Bi_Directional_1To1 {

	public static void main(String[] args) {

		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {			
			session.beginTransaction();

			int id = 3;
			InstructorDetails instructor = session.get(InstructorDetails.class, id);
			
			System.out.println(instructor);
			
			// print associated instructor
			System.out.println("Associated Instructor : " + instructor.getInstructor());

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}


