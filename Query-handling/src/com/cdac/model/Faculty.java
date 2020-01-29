package com.cdac.model;

public class Faculty {
	
	private int faculty_id;
	private String userName;
	private int subject_id;

	private String firstName;
	private String lastName;
	
	
	public int getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Faculty [faculty_id=" + faculty_id + ", userName=" + userName + ", subject_id=" + subject_id + "]";
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