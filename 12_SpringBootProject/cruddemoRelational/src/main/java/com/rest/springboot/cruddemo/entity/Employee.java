package com.rest.springboot.cruddemo.entity;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Firstname")
	private String Firstname;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="Email")
	private String Email;
	
	public Employee() {
		
	}

	public Employee(String firstname, String lastName, String email) {
		Firstname = firstname;
		LastName = lastName;
		Email = email;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	// to string
	
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Firstname=" + Firstname + ", LastName=" + LastName + ", Email=" + Email + "]";
	}
	

	
}
