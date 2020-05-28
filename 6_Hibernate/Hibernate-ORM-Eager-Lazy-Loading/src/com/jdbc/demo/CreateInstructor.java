package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.InstructorDetails;
import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;

public class CreateInstructor {

	public static void main(String[] args) {
		
		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(One2Many_Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(One2Many_Course.class)
				.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// create Student Object
			One2Many_Instructor instructor = new One2Many_Instructor("Soham", "Roy", "soham@gmail.com");
			InstructorDetails instructorDetails = new InstructorDetails("GameWithSoham", "Ps Gaming");
			
			// associate the objects
			instructor.setInstructor_detail_id(instructorDetails);
			
			session.beginTransaction();
			
			session.save(instructor);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}
