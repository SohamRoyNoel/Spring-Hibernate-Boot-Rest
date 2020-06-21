package com.rest.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TestScenario")
public class TestScenarioMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TestScenarioID")
	private int TestScenarioID;
	
	@Column(name="TestScenarioName")
	private String TestScenarioName;
	
	@Column(name="ProjectName")
	private String ProjectName;
	
	

	public TestScenarioMaster() {
		
	}

	public TestScenarioMaster(String testScenarioName, String projectName) {
		TestScenarioName = testScenarioName;
		ProjectName = projectName;
	}

	public int getTestScenarioID() {
		return TestScenarioID;
	}

	public void setTestScenarioID(int testScenarioID) {
		TestScenarioID = testScenarioID;
	}

	public String getTestScenarioName() {
		return TestScenarioName;
	}

	public void setTestScenarioName(String testScenarioName) {
		TestScenarioName = testScenarioName;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	@Override
	public String toString() {
		return "TestScenarioMaster [TestScenarioID=" + TestScenarioID + ", TestScenarioName=" + TestScenarioName
				+ ", ProjectName=" + ProjectName + "]";
	}
	
	
	
}
