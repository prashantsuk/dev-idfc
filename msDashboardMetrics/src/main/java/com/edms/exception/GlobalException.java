package com.edms.exception;

import java.io.Serializable;

public class GlobalException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public GlobalException() {
	}

	public GlobalException(String message) {
		super(message);
	}

	public GlobalException(String message, Throwable cause) {
		super(message, cause);
	}

	public GlobalException(Throwable cause) {
		super(cause);
	}

	public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
