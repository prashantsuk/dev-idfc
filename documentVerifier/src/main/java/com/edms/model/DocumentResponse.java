package com.edms.model;

public class DocumentResponse {

	private boolean validDocument;

	private String errMessage;

	public boolean getValidDocument() {
		return validDocument;
	}

	public void setValidDocument(boolean validDocument) {
		this.validDocument = validDocument;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

}
