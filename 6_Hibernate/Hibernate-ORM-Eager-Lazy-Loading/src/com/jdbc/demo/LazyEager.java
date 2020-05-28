package com.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.models.InstructorDetails;
import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;

public class LazyEager {

	public static void main(String[] args) {


		// build session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(One2Many_Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(One2Many_Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {	

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			One2Many_Instructor tempInstructor = session.get(One2Many_Instructor.class, theId);		

			System.out.println("instructor : " + tempInstructor);

			System.out.println("Courses : " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
/*
OUTPUT OF EAGER LOADING : ( all data fetched once )
Hibernate: select one2many_i0_.id as id1_2_0_, one2many_i0_.email as email2_2_0_, one2many_i0_.first_name as first_na3_2_0_, one2many_i0_.instructor_detail_id as instruct5_2_0_, one2many_i0_.last_name as last_nam4_2_0_, instructor1_.id as id1_0_1_, instructor1_.hobby as hobby2_0_1_, instructor1_.youtube_channel as youtube_3_0_1_ from One2Many_Instructor one2many_i0_ left outer join instructor_detail instructor1_ on one2many_i0_.instructor_detail_id=instructor1_.id where one2many_i0_.id=?
instructor : Instructor [id=1, firstName=Soham, lastName=Roy, email=soham@gmail.com, instructorDetail=Instructor [id=5, youtube_channel=GameWithSoham, hobby=Ps Gaming]]
Hibernate: select courses0_.instructor_id as instruct3_1_0_, courses0_.id as id1_1_0_, courses0_.id as id1_1_1_, courses0_.instructor_id as instruct3_1_1_, courses0_.title as title2_1_1_ from One2Many_Course courses0_ where courses0_.instructor_id=?
Courses : [Course [id=2, title=The Pinball Masterclass]]
Done!


******************************************************************************************************

OUTPUT OF Lazy LOADING : ( data fetched accordingly )
Hibernate: select one2many_i0_.id as id1_2_0_, one2many_i0_.email as email2_2_0_, one2many_i0_.first_name as first_na3_2_0_, one2many_i0_.instructor_detail_id as instruct5_2_0_, one2many_i0_.last_name as last_nam4_2_0_, instructor1_.id as id1_0_1_, instructor1_.hobby as hobby2_0_1_, instructor1_.youtube_channel as youtube_3_0_1_ from One2Many_Instructor one2many_i0_ left outer join instructor_detail instructor1_ on one2many_i0_.instructor_detail_id=instructor1_.id where one2many_i0_.id=?
instructor : Instructor [id=1, firstName=Soham, lastName=Roy, email=soham@gmail.com, instructorDetail=Instructor [id=5, youtube_channel=GameWithSoham, hobby=Ps Gaming]]
Hibernate: select courses0_.instructor_id as instruct3_1_0_, courses0_.id as id1_1_0_, courses0_.id as id1_1_1_, courses0_.instructor_id as instruct3_1_1_, courses0_.title as title2_1_1_ from One2Many_Course courses0_ where courses0_.instructor_id=?
Courses : [Course [id=2, title=The Pinball Masterclass]]
Done!






*/