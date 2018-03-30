package com.hexa.dao;

public class NotFoundException extends Exception {

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public NotFoundException(String message) {
		super(message);
		
	}
	
}
	