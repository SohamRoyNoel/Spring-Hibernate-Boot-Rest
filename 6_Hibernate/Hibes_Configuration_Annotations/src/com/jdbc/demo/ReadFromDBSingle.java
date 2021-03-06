package com.jdbc.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.Students;

public class ReadFromDBSingle {

	public static void main(String[] args) {
		/*
		 * In Query : ["from Students s where s.firstname='John'"]
		 * firstname is copied from Student MODEL, not from DB table column name
		 * Bcz. HQL treats table's column name as Entity
		 * */

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {		
			// start a transaction
			session.beginTransaction();

			// query students
			List<Students> theStudents = session.createQuery("from Students").getResultList();
			// display the students
			// displayStudents(theStudents);
			/*Student [id=1, firstName=John, lastName=Morston, email=rdr2@gmail.com]
				Student [id=2, firstName=Arther, lastName=Morgan, email=rdr2@gmail.com]
				Student [id=3, firstName=Dutch, lastName=Van Dar Lint, email=rdr2@gmail.com]
				Student [id=4, firstName=Seide, lastName=Adler, email=rdr2@gmail.com]
				Student [id=5, firstName=Abigal, lastName=Morston, email=rdr2@gmail.com]
				Student [id=6, firstName=John, lastName=Morston, email=rdr2@gmail.com]
				Student [id=7, firstName=Tammy, lastName=Abadin, email=rdr2@gmail.com]
				Student [id=8, firstName=John, lastName=Abadin, email=rdr2@gmail.com]*/


			List<Students> theStudents1 = session.createQuery("from Students s where s.firstname='John'").getResultList();
			//displayStudents(theStudents1);
			/*Student [id=1, firstName=John, lastName=Morston, email=rdr2@gmail.com]
				Student [id=6, firstName=John, lastName=Morston, email=rdr2@gmail.com]
				Student [id=8, firstName=John, lastName=Abadin, email=rdr2@gmail.com]*/

			List<Students> theStudents2 = session.createQuery("from Students s where s.firstname LIKE 'T%'").getResultList();
			displayStudents(theStudents2);
			/*Student [id=7, firstName=Tammy, lastName=Abadin, email=rdr2@gmail.com]*/
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Students> theStudents) {
		for (Students tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
