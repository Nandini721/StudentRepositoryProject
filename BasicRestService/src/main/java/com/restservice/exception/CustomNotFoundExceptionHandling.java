package com.restservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomNotFoundExceptionHandling  extends RuntimeException {


	public CustomNotFoundExceptionHandling(String message) {
		super(message);
		
	}
}
