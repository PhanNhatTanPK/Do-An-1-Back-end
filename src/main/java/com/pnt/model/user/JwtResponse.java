package com.pnt.model.user;

public class JwtResponse {
	String token;
	
	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public JwtResponse(String token) {
		// TODO Auto-generated constructor stub
		this.token=token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
