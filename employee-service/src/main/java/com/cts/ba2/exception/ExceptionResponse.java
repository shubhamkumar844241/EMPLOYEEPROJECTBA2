package com.cts.ba2.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;

}
