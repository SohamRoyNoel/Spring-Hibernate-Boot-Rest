package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Students;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// create Student Object
			System.out.println("Create Object");
			Students s = new Students("John", "Morston", "rdr2@gmail.com");
			System.out.println("Transaction Started");
			session.beginTransaction();
			System.out.println("Save Transection");
			session.save(s);
			System.out.println("commit");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}
