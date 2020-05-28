package com.jdbc.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "One2Many_Course")
public class One2Many_Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
		
	/*
	 * In case of Course : [Many courses have 1 Instructor : so it is MANY-2-One]  
	 * */
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private One2Many_Instructor instructor_id;

	public One2Many_Course() {	}

	public One2Many_Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public One2Many_Instructor getInstructors() {
		return instructor_id;
	}

	public void setInstructors(One2Many_Instructor instructors) {
		this.instructor_id = instructors;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
				
	}
	
	
	
}
