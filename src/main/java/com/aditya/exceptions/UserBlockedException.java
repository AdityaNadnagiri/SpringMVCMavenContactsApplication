package com.aditya.exceptions;

public class UserBlockedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * creates user object without error description	
	 */
	public UserBlockedException() {
		
	}
	/*
	 * creates user object with error description	
	 */
	public UserBlockedException(String errDisc) {
		
		super(errDisc);
	}
	
	
	
}
