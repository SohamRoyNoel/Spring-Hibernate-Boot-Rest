package com.example.relational.BootRelations.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Emp_Id")
	private int Emp_Id;
	@Column(name="Emp_Name")
	private String Emp_Name;
	@Column(name="Emp_Email")
	private String Emp_Email;
	
	// transient field
	private transient int Designation_Id;
	
	@ManyToOne
	@JoinColumn(name = "Designation_Id")
	private Designation designation;
	
	public Employee() {
		
	}

	public Employee(int emp_Id, String emp_Name, String emp_Email) {
		Emp_Name = emp_Name;
		Emp_Email = emp_Email;
	}

	public int getEmp_Id() {
		return Emp_Id;
	}
	
	

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public int getDesignation_Id() {
		return Designation_Id;
	}

	public void setDesignation_Id(int designation_Id) {
		Designation_Id = designation_Id;
	}

	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return Emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}

	public String getEmp_Email() {
		return Emp_Email;
	}

	public void setEmp_Email(String emp_Email) {
		Emp_Email = emp_Email;
	}

	
	
	
}
