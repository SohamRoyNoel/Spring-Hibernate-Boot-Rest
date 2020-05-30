package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Many2Many_Review;
import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;
import com.jdbc.models.One2One_InstructorDetails;

public class Many2Many_Insertion {

	public static void main(String[] args) {

		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(One2Many_Instructor.class)
				.addAnnotatedClass(One2One_InstructorDetails.class)
				.addAnnotatedClass(One2Many_Course.class)
				.addAnnotatedClass(Many2Many_Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {	

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			One2Many_Course tempCourses = new One2Many_Course("Thats my new Java Course108");
			//One2Many_Course tempCourse = session.get(One2Many_Course.class, tempCourses.getId());		

			// create some reviews
			Many2Many_Review tempRev1 = new Many2Many_Review("Unique Rev1");
			Many2Many_Review tempRev2 = new Many2Many_Review("Best One1");

			// add reviews to instructor
			tempCourses.add(tempRev1);
			tempCourses.add(tempRev2);

			// save the courses
			session.save(tempCourses);
			
			System.out.println("Reviews : " + tempCourses.getReviews());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
