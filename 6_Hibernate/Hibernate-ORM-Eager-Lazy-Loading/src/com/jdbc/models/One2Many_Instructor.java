package com.jdbc.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "One2Many_Instructor")
public class One2Many_Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
		
	/*
	 * @OneToOne(mappedBy = "instructor_detail_id", ****
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
		private One2Many_Instructor instructor;
	 * 
	 * */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id") /*****/
	private InstructorDetails instructor_detail_id;
	
	
	
	
	/*
	 * From Instructor's prospective [ 1 Instructor ha many course] 
	 * So, it is [1-TO-Many]
	 * Next, let Hibernate know the mapping property :private One2Many_Instructor instructors;
	 * 
	 * FROM COURSE MODEL
	 * @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
		@JoinColumn(name = "instructor_id") #####
		private One2Many_Instructor instructor_id;
	 * 
	 * */
	@OneToMany(mappedBy = "instructor_id",  /*####*/
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<One2Many_Course> courses;


	public One2Many_Instructor() {	}

	public One2Many_Instructor(String first_name, String last_name, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetails getInstructor_detail_id() {
		return instructor_detail_id;
	}

	public void setInstructor_detail_id(InstructorDetails instructor_detail_id) {
		this.instructor_detail_id = instructor_detail_id;
	}
	
	public List<One2Many_Course> getCourses() {
		return courses;
	}

	public void setCourses(List<One2Many_Course> courses) {
		this.courses = courses;
	}
	
	
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", email=" + email + ", instructorDetail=" + instructor_detail_id + "]";
				
	}
	
	// Convinence method for bi directional Relationship
	
	public void add(One2Many_Course tempCourse) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		
		// add Courses to the list
		courses.add(tempCourse);
		
		// let course know about new Instructor
		tempCourse.setInstructors(this);
	}

}
