package com.edms.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.edms.model.ErrorResponse;

@ControllerAdvice
public class DocumentExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentExceptionHandler.class);

	private static final String STATUS_CODE = "An exception occurred with StatusCode: {}";
	private static final String STATUS_MESSAGE = "An exception occurred : {}";

	@ExceptionHandler(value = PasswordMatchException.class)
	public ResponseEntity<ErrorResponse> handleGenericDataFoundException(PasswordMatchException e) {
		
		final ErrorResponse error = new ErrorResponse("NOT_FOUND_ERROR", e.getMessage());
		error.setTimestamp(new Timestamp(System.currentTimeMillis()));
		error.setStatus(HttpStatus.FORBIDDEN.value());
		LOGGER.error(STATUS_CODE, HttpStatus.FORBIDDEN.value());
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		final String stackTrace = sw.toString();
		LOGGER.error(STATUS_MESSAGE, stackTrace);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}

}