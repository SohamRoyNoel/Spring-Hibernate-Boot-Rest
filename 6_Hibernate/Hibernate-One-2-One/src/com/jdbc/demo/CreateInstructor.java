package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Instructor;
import com.jdbc.models.InstructorDetails;

public class CreateInstructor {

	public static void main(String[] args) {
		
		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// create Student Object
			Instructor instructor = new Instructor("Soham", "Roy", "soham@gmail.com");
			InstructorDetails instructorDetails = new InstructorDetails("CodeWithSoham", "Gaming");
			
			// associate the objects
			instructor.setInstructor_details_id(instructorDetails);
			
			session.beginTransaction();
			
			session.save(instructor);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}
