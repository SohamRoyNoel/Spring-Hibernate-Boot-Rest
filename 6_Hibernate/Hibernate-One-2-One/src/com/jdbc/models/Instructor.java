package com.jdbc.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

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
	 * CascadeType.ALL : If one table is updated other one must be updated
	 * 
	 * Making the reference To the foreign key of Instructor_Details table : 
	 * 
	 * UNI-Directional
	 * 
	 * so we can add data into Instructor table then Instructor details
	 * */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_details_id")
	private InstructorDetails instructor_details_id;
	

	public Instructor() {	}


	public Instructor(String first_name, String last_name, String email) {
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


	public InstructorDetails getInstructor_details_id() {
		return instructor_details_id;
	}


	public void setInstructor_details_id(InstructorDetails instructor_details_id) {
		this.instructor_details_id = instructor_details_id;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + first_name + ", lastName=" + last_name + ", email=" + email + ", instructorDetail=" + instructor_details_id + "]";
				
	}

	
	
	
	
}
