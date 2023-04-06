package com.edms.exception;

public class PasswordMatchException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PasswordMatchException(String message) {
		super(message);
	}
}
