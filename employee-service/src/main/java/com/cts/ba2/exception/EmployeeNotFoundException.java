package com.cts.ba2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	//constructor to get custom message gets updated at runtime if exception occur
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
