package com.edms.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {

	String errorCode;

	String errorMsg;

	int status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Timestamp timestamp;

	public ErrorResponse(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public int getStatus() {
		return status;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}