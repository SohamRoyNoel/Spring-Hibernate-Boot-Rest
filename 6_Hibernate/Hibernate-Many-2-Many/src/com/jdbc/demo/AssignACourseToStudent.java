package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Course;
import com.jdbc.models.Student;

public class AssignACourseToStudent {

	public static void main(String[] args) {

		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {	

			// start a transaction
			session.beginTransaction();

			// Retrive
			int retrivableid = 1;
			Student retriveStudent = session.get(Student.class, retrivableid);
			System.out.println("Retrive student : " + retriveStudent);

			// create course
			Course tempCourses = new Course("Thats my new Django Course108");
			Course tempCourses1 = new Course("Thats my new Jquey Course108");
			
			
			retriveStudent.addCourses(tempCourses);
			retriveStudent.addCourses(tempCourses1);
			
			session.save(retriveStudent);
			
			
			session.save(tempCourses);
			session.save(tempCourses1);
			
			// retrive assigned Data
			System.out.println("Courses belong to 1 : " + retriveStudent.getCourses()); 
			
			/*Courses belong to 1 : [Course [id=3 title=Thats my new Java Course108], 
			Course [id=8 title=Thats my new Django Course108], 
			Course [id=9 title=Thats my new Jquey Course108], 
			Course [id=10 title=Thats my new Django Course108],
			Course [id=11 title=Thats my new Jquey Course108]]*/


			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
