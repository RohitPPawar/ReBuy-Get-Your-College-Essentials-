package com.rebuy.exception;

public class InvalidUserException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMsg;

	public InvalidUserException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
	
	
}
