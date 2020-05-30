package com.jdbc.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Many2Many_Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "comment")
	private String comment;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private One2Many_Course course_id;
	
	

	public Many2Many_Review() {	}

	public Many2Many_Review(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

//	public One2Many_Course getCourse_id() {
//		return course_id;
//	}
//
//	public void setCourse_id(One2Many_Course course_id) {
//		this.course_id = course_id;
//	}
//	
	@Override
	public String toString() {
		return "Course [id=" + id + " Comment=" + comment + "]";
				
	}
	
	
	
}
