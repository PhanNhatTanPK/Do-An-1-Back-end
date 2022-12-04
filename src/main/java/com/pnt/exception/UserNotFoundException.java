package com.pnt.exception;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Don't find user with this Usercode");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
