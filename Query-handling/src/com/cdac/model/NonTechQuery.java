package com.cdac.model;

import java.sql.Date;

public class NonTechQuery {
	
	private int id;
	private String nontech_ques;
	private String status;
	private int posted_by;
	private Date posted_on;
		 
	@Override
	public String toString() {
		return "NontechnicalQuery [id=" + id + ", nontech_ques=" + nontech_ques + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public NonTechQuery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNontech_ques() {
		return nontech_ques;
	}
	public void setNontech_ques(String nontech_ques) {
		this.nontech_ques = nontech_ques;
	}
	public int getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(int posted_by) {
		this.posted_by = posted_by;
	}
	public Date getPosted_on() {
		return posted_on;
	}
	public void setPosted_on(Date posted_on) {
		this.posted_on = posted_on;
	}	

}