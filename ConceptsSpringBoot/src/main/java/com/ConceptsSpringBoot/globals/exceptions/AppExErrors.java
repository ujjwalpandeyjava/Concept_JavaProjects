package com.ConceptsSpringBoot.globals.exceptions;

import org.springframework.http.HttpStatus;

public enum AppExErrors {
	NO_CREDENTIALS_FOUND(1001, "Please provide email and password", HttpStatus.BAD_REQUEST,
			"Send valid 'email' and 'pass' headers."),
	EMAIL_NOT_IN_BODY(1002, "Email not found!", HttpStatus.BAD_REQUEST, "Add 'email' as base64 in header.");

	private final int code;
	private final String message;
	private final HttpStatus status;
	private final String whatToDo;

	AppExErrors(int code, String message, HttpStatus status, String whatToDo) {
		this.code = code;
		this.message = message;
		this.status = status;
		this.whatToDo = whatToDo;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public String getWhatToDo() {
		return this.whatToDo;
	}

	@Override
	public String toString() {
		return code + ": " + message;
	}
}
