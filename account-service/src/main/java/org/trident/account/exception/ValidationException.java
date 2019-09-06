package org.trident.account.exception;

import org.springframework.validation.Errors;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 6823059913657989813L;
	private String errorMessage;
	private Errors errors;

	public ValidationException(final String errorMessage, final Errors errors) {
		this.errorMessage = errorMessage;
		this.errors = errors;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Errors getErrors() {
		return errors;
	}

}
