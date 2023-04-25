package com.school_project.lms.web.dto;

import com.school_project.lms.entity.UserType;

public class UserRegistrationDto {
	private int userId;
	private UserType userType;
	private String UserName;
	private String email;
	private String adress;
	private int mobile;
	private String password;
	
	public UserRegistrationDto() {
		
	}
	public UserRegistrationDto(int userId, UserType userType, String userName, String email, String adress, int mobile,
			String password) {
		super();
		this.userId = userId;
		this.userType = userType;
		UserName = userName;
		this.email = email;
		this.adress = adress;
		this.mobile = mobile;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
