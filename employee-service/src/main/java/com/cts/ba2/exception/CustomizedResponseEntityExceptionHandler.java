package com.cts.ba2.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// to handle the exceptions globally.
@ControllerAdvice
@RestController 
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	//this method is used to handle specifc exception having custom message
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request)  {
		
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),exception.getMessage(),request.getDescription(false));
	
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
}
