package com.cdac.model;

public class TechQuery {
	
	private int q_id;
	
	private int subject_id;
	
	private int topic_id;
	
	private String subject;
	
	private String query;
	
	private String techResponse;
	
	

	@Override
	public String toString() {
		return "TechQuery [q_id=" + q_id + ", subject_id=" + subject_id + ", topic_id=" + topic_id + ", subject="
				+ subject + ", query=" + query + ", techResponse=" + techResponse + ", topic=" + topic + ", ans=" + ans
				+ "]";
	}

	private String topic;
	
	private String ans;
	
	

	
	public TechQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getAns() {
		return ans;
	}


	public void setAns(String ans) {
		this.ans = ans;
	}


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}


	public int getTopic_id() {
		return topic_id;
	}


	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getTechResponse() {
		return techResponse;
	}

	public void setTechResponse(String techResponse) {
		this.techResponse = techResponse;
	}

}
