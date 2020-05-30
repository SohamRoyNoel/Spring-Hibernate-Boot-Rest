package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;
import com.jdbc.models.One2One_InstructorDetails;

/*
 * 
 * Delete Course without deleting the Instructor
 * 
 * */
public class DeleteCourse {

	public static void main(String[] args) {
		
		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(One2Many_Instructor.class)
				.addAnnotatedClass(One2One_InstructorDetails.class)
				.addAnnotatedClass(One2Many_Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {	

			// start a transaction
			session.beginTransaction();
			
			int deletableCourseId = 1;
			// get the Course from value by ID
			One2Many_Course delCourse = session.get(One2Many_Course.class, deletableCourseId);		

			session.delete(delCourse);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
