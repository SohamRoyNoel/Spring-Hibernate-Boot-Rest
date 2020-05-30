package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Many2Many_Review;
import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;
import com.jdbc.models.One2One_InstructorDetails;

public class GetCourseReviewById {

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

			int findCourseRevId = 8;
			// get the Course from value by ID
			One2Many_Course delCourse = session.get(One2Many_Course.class, findCourseRevId);		

			System.out.println("Course Name : " + delCourse);
			System.out.println("Review : " + delCourse.getReviews());
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
