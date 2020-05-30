package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Course;
import com.jdbc.models.Student;



public class insertion {

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

			// get the instructor from db
			Course tempCourses = new Course("Thats my new Python Course108");
			Course tempCourses1 = new Course("Thats my new PHP Course108");
			session.save(tempCourses);
			session.save(tempCourses1);


			// create some reviews
			Student tempStu1 = new Student("UniqueR", "Name", "uR@g.com");
			Student tempStu2 = new Student("NonUniqueR", "Name", "nuR@g.com");
			Student tempStu3 = new Student("UniqueRS", "Name", "uRS@g.com");
			Student tempStu4 = new Student("NonUniqueRS", "Name", "nuRS@g.com");

			// add reviews to instructor
			tempCourses.addStudent(tempStu1);
			tempCourses.addStudent(tempStu2);
			tempCourses1.addStudent(tempStu3);
			tempCourses1.addStudent(tempStu4);

			// save the courses
			session.save(tempStu1);
			session.save(tempStu2);
			session.save(tempStu3);
			session.save(tempStu4);

			System.out.println("Students : " + tempCourses.getStudents());



			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
