package com.altaf.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.altaf.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ExceptionController {

	// Handle CustomException
	@ExceptionHandler(ErrorMessage.class)
	public ResponseEntity<ErrorResponse> handleCustomException(ErrorMessage ex, HttpServletRequest request) {
	    log.error("CustomException Occured:: URL=" + request.getRequestURL());
		log.error(" Exception Message code" + ex.getMessageCode());
		log.error(" Exception Message desc" + ex.getMessageDiscription());
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), ex.getMessageCode(),
				ex.getMessageDiscription());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	// Handle other global exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), "ERRO4",ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
