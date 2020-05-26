package com.models;

import java.util.LinkedHashMap;

public class Students {

	String firstname;
	String lastname;
	
	// Radio Button Element
	String programmingLanguage;
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	
	// Checkbox
	private String[] ops;
	
	public String[] getOps() {
		return ops;
	}
	public void setOps(String[] ops) {
		this.ops = ops;
	}
	// Dynamic Checkbox Population
	String[] lng;
	private LinkedHashMap<String, String> favLang;
	
	public String[] getLng() {
		return lng;
	}
	public void setLng(String[] lng) {
		this.lng = lng;
	}
	public LinkedHashMap<String, String> getFavLang() {
		return favLang;
	}

	// Dropdown Element
	String country;
	
	// Dynamic Dropdown : reading from MODEL
	String player;
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	// Drop Down List class
	private LinkedHashMap<String, String> favPlayer;
	public Students() {
		// initializing Dynamic Dropdown
		favPlayer = new LinkedHashMap<String, String>();
		favPlayer.put("CR", "Ronaldo");
		favPlayer.put("MS", "Messy");
		favPlayer.put("NM", "Naimar");
		favPlayer.put("LM", "Luka M");
		// Initialize Dynamic Checkbox
		favLang = new LinkedHashMap<String, String>();
		favLang.put("RUBY", "Rudy");
		favLang.put("Perl", "Perl");
		favLang.put("Python", "Python");
		favLang.put("Javascript", "Javascript");
		
	}
	public LinkedHashMap<String, String> getFavPlayer() {
		return favPlayer;
	}
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	// Input Box
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}
