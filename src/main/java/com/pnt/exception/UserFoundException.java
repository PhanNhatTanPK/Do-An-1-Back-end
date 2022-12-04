package com.pnt.exception;

public class UserFoundException extends Exception{
	
	public UserFoundException() {
		// TODO Auto-generated constructor stub
		super("User with Usercode is already create");
	}
	
	public UserFoundException(String msg) {
		super(msg);
	}
}
