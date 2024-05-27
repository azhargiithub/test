package com.neosoft.exceptionHandler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String errorMessage(MethodArgumentNotValidException e) {
		return e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
	}
	
	
}
