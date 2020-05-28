package com.jdbc.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtube_channel;
	
	@Column(name = "hobby")
	private String hobby;
	
	/*
	 * 
	 * Making bi-directional:
	 * 1. create an Instructor Property
	 * 2. this "instructor_details_id" belongs to 
	 * 
	 *  @OneToOne(cascade = CascadeType.ALL)
	 *	@JoinColumn(name = "instructor_details_id")
	 *	private InstructorDetails instructor_details_id;
	 * 
	 * */
	@OneToOne(fetch = FetchType.LAZY,
			mappedBy = "instructor_detail_id", 
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	private One2Many_Instructor instructor;
	
	public InstructorDetails() { }

	public InstructorDetails(String youtube_channel, String hobby) {
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	/*
	 * Bi_directional
	 * 
	 * */
	public One2Many_Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(One2Many_Instructor instructor) {
		this.instructor = instructor;
	}
	
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby + "]";
				
	}
}
