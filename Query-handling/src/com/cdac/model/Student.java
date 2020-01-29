package com.cdac.model;

public class Student extends Login{
	
	private int sId;
	private String firstName;
	private String lastName;
	
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Student() {
		super();
		
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
