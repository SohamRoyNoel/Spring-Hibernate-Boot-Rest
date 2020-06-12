package JacksonDataBinding._JacksonDataBinding.jackson.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * Deliberately avoids the property that has no GETTER & Setter
 * */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {

	private boolean active;
	private String lastName;
	private String firstName;
	private int id;
	
	private Address address;
	
	private String[] languages;
		
	public Student() {
		
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	
	
	
}
