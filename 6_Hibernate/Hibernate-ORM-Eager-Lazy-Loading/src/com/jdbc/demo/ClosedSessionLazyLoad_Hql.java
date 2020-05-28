package com.jdbc.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jdbc.models.InstructorDetails;
import com.jdbc.models.One2Many_Course;
import com.jdbc.models.One2Many_Instructor;

public class ClosedSessionLazyLoad_Hql {

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
			/*
			 * 
			 * Use the PROPERTY in the One2Many_Instructor.java
			 * 
			 * @OneToMany(mappedBy = "instructor_id",
			   cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
			   private List<One2Many_Course> courses; --------------------------------------------------------------------|
			 * 																											  |
			 * 																											  |
			 * */
			Query<One2Many_Instructor> instQuery = session.createQuery("select i from One2Many_Instructor i join fetch i.courses where i.id=:theInstId_AnyVariableName", One2Many_Instructor.class);
			
			instQuery.setParameter("theInstId_AnyVariableName", theId);
				
			One2Many_Instructor tempInstructor = instQuery.getSingleResult(); 

			System.out.println("instructor : " + tempInstructor);

			

			// commit transaction
			session.getTransaction().commit();

			// As We know LAZY loading needs a open session : here we are calling it when the session is closed
			System.out.println("Courses : " + tempInstructor.getCourses());
			
			
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
/*

Hibernate: select one2many_i0_.id as id1_2_0_, courses1_.id as id1_1_1_, one2many_i0_.email as email2_2_0_, one2many_i0_.first_name as first_na3_2_0_, one2many_i0_.instructor_detail_id as instruct5_2_0_, one2many_i0_.last_name as last_nam4_2_0_, courses1_.instructor_id as instruct3_1_1_, courses1_.title as title2_1_1_, courses1_.instructor_id as instruct3_1_0__, courses1_.id as id1_1_0__ from One2Many_Instructor one2many_i0_ inner join One2Many_Course courses1_ on one2many_i0_.id=courses1_.instructor_id where one2many_i0_.id=?
Hibernate: select instructor0_.id as id1_0_0_, instructor0_.hobby as hobby2_0_0_, instructor0_.youtube_channel as youtube_3_0_0_ from instructor_detail instructor0_ where instructor0_.id=?
Hibernate: select one2many_i0_.id as id1_2_1_, one2many_i0_.email as email2_2_1_, one2many_i0_.first_name as first_na3_2_1_, one2many_i0_.instructor_detail_id as instruct5_2_1_, one2many_i0_.last_name as last_nam4_2_1_, instructor1_.id as id1_0_0_, instructor1_.hobby as hobby2_0_0_, instructor1_.youtube_channel as youtube_3_0_0_ from One2Many_Instructor one2many_i0_ left outer join instructor_detail instructor1_ on one2many_i0_.instructor_detail_id=instructor1_.id where one2many_i0_.instructor_detail_id=?
instructor : Instructor [id=1, firstName=Soham, lastName=Roy, email=soham@gmail.com, instructorDetail=Instructor [id=5, youtube_channel=GameWithSoham, hobby=Ps Gaming]]
Courses : [Course [id=2, title=The Pinball Masterclass]]
Done!


 */