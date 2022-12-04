package com.pnt.model.user;

public class JwtRequest {
	private String userCode;
	private String password;
	
	public JwtRequest() {
		// TODO Auto-generated constructor stub
	}

	public JwtRequest(String userCode, String password) {
		super();
		this.userCode = userCode;
		this.password = password;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
