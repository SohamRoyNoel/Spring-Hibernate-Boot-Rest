package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Instructor;
import com.jdbc.models.InstructorDetails;

public class DeleteInstructorDetails {

	public static void main(String[] args) {

		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {			
			session.beginTransaction();

			int deletableID = 3;
			InstructorDetails instructordetails = session.get(InstructorDetails.class, deletableID);

			if (instructordetails != null) {
				session.delete(instructordetails);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
