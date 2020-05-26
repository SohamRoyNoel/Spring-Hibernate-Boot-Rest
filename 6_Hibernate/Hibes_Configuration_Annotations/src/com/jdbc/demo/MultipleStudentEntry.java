package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Students;

public class MultipleStudentEntry {

	public static void main(String[] args) {

		// build session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).buildSessionFactory();
				
				// Create Session
				Session session = factory.getCurrentSession();
				
				try {
					// create Student Object
					System.out.println("Create Object");
					Students s = new Students("Arther", "Morgan", "rdr2@gmail.com");
					Students s1 = new Students("Dutch", "Van Dar Lint", "rdr2@gmail.com");
					Students s2 = new Students("Seide", "Adler", "rdr2@gmail.com");
					System.out.println("Transaction Started");
					session.beginTransaction();
					System.out.println("Save Transection");
					session.save(s);
					session.save(s1);
					session.save(s2);
					System.out.println("commit");
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
				}

	}

}
