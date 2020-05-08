package com.cts.ba2.exception;

public class ProjectNotFoundException extends RuntimeException {
	
	//constructor to get custom message gets updated at runtime if exception occur
	public ProjectNotFoundException(String message) {
		super(message);
	}

}
