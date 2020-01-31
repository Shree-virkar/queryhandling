package com.cdac.model;

public class Login {
	
	private int userId; 
	private String userName;
	private String passWord;
	private String userRole;
	private String emailId;
	private String contactNo;
	
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
public String toString() {
	return "Login [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", userRole=" + userRole
			+ ", emailId=" + emailId + ", contactNo=" + contactNo + "]";
}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
