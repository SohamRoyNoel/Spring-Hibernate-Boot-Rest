package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Students;

public class UpdateDB {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {	
			session.beginTransaction();
			String updatatbleId = "1";
			Students students = session.get(Students.class, updatatbleId);
			students.setFirstname("House");
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
