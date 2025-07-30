package com.ConceptsSpringBoot.globals.exceptions;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
	private final AppExErrors error;

	public ApplicationException(AppExErrors error) {
		super(error.getMessage());
		this.error = error;
	}

	public ApplicationException(AppExErrors error, String message) {
		super(message);
		this.error = error;
	}

	public HttpStatus getHttpStatus() {
		return error.getStatus();
	}

	public int getCode() {
		return error.getCode();
	}

	public String getWhatToDo() {
		return error.getWhatToDo();
	}
}

// How to use
// throw new ApplicationException(AppExErrors.NO_CREDENTIALS_FOUND);
// throw new ApplicationException(AppExErrors.EMAIL_NOT_IN_BODY, "Email header is missing in request");
