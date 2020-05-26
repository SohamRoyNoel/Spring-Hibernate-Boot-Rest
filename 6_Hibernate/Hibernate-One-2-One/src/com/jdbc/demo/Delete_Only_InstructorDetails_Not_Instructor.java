package com.jdbc.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Instructor;
import com.jdbc.models.InstructorDetails;

/*
 * 
 * We have to modify the cascade in Models
 * 
 * */
public class Delete_Only_InstructorDetails_Not_Instructor {

	public static void main(String[] args) {

		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {			
			session.beginTransaction();

			int deletableID = 4;
			InstructorDetails instructordetails = session.get(InstructorDetails.class, deletableID);

			if (instructordetails != null) {
				
				/*
				 * Now before delete we have to REMOVE the BI DIRECTIONAL relation ship between Instructors and InstructorDetails
				 * It will remove the FOREIGN key field in the other table
				 * */
				instructordetails.getInstructor().setInstructor_details_id(null);
				session.delete(instructordetails);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
