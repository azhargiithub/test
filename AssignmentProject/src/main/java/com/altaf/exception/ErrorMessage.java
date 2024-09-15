package com.altaf.exception;

import lombok.Data;

@Data
public class ErrorMessage extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String messageCode;;
	private String messageDiscription;

	public ErrorMessage(String messageCode, String messageDiscription) {
		super();
		this.messageCode = messageCode;
		this.messageDiscription = messageDiscription;
	}

}
