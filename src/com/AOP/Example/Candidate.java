package com.AOP.Example;

public class Candidate {
	private String name;
	private  String email;
	private int experience;
	
	
	
	public String getName() {
		System.out.println("Candidate name : "+ name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		System.out.println("Candidate email : "+ email);
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExperience() {
		System.out.println("Candidate exp : "+ experience);
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void printThrowException(){
	      System.out.println("Exception raised");
	      throw new IllegalArgumentException();
	   }

}
