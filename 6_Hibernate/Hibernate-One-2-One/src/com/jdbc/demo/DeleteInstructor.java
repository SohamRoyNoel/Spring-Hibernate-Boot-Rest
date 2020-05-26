package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Instructor;
import com.jdbc.models.InstructorDetails;

public class DeleteInstructor {

	public static void main(String[] args) {

		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {			
			session.beginTransaction();

			int deletableID = 1;
			Instructor instructor = session.get(Instructor.class, deletableID);

			if (instructor != null) {
				session.delete(instructor);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
