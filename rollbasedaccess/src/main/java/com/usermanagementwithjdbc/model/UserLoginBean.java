package com.usermanagementwithjdbc.model;

public class UserLoginBean {
	
	private String userName;
	private String password;
	
	public UserLoginBean() {
		// TODO Auto-generated constructor stub
	}

	public UserLoginBean(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginBean [userName=" + userName + ", password=" + password + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
