package com.altaf.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {
	
	 private LocalDateTime timestamp;
	    private String message;
	    private String description;

	    public ErrorResponse(LocalDateTime timestamp, String message, String description) {
	        this.timestamp = timestamp;
	        this.message = message;
	        this.description = description;
	    }
}
