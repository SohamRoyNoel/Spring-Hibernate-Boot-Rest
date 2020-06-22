package com.example.relational.BootRelations.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="Designation")
public class Designation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Designation;
	private float Salary;
	
	@OneToMany(targetEntity=Employee.class, mappedBy="designation", fetch=FetchType.LAZY)
	private Set<Employee> employee_Emp_Id;
	
	public Designation() {
		
	}

	public Designation(String designation, float salary) {
		Designation = designation;
		Salary = salary;
	}

	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float salary) {
		Salary = salary;
	}

//	@Override
//	public String toString() {
//		return "Designation [Designation=" + Designation + ", Salary=" + Salary + ", employee=" + employee + "]";
//	}
	
	
}

