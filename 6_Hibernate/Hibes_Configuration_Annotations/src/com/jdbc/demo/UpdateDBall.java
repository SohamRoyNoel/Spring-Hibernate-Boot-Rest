package com.jdbc.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Students;

public class UpdateDBall {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {		
			// start a transaction
			session.beginTransaction();

			// query students
			session.createQuery("update Students set email='cog@cognizant.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		
	}

}
