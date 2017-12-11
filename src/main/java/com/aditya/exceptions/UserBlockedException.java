package com.aditya.exceptions;

public class UserBlockedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * creates user object without error discription	
	 */
	public UserBlockedException() {
		
	}
	/*
	 * creates user object with error discription	
	 */
	public UserBlockedException(String errDisc) {
		
		super(errDisc);
	}
	
	
	
}
