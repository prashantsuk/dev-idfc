package com.edms.exception;

public class DocumentFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DocumentFoundException(String message) {
		super(message);
	}
}
