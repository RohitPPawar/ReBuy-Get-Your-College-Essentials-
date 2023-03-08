package com.rebuy.exception;

public class InvalidUserException extends Exception {
	
	String errorMsg;

	public InvalidUserException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
	
	
}
