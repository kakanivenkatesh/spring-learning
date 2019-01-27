package com.spring.JDBC;

public class Candidate {
	
	private String Name;
	private String Email;
	private int id;
	
	public Candidate(){
		
	}
	public Candidate(int id, String name, String email) {
		this.id =id;
		this.Name= name;
		this.Email= email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	

}
