package org.trident.designer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public final Error handleValidationException(ValidationException e, WebRequest request) {
		final String errorMessage = e.getErrorMessage();
		final Errors errors = e.getErrors();
		final Error errorDto = new Error();
		errorDto.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorDto.setErrorMessage(errorMessage);

		if (errors != null) {
			errors.getFieldErrors().forEach(error -> {
				FieldError fieldErrorDto = new FieldError();
				fieldErrorDto.setField(error.getField());
				fieldErrorDto.setErrorMessage(error.getDefaultMessage());
				fieldErrorDto.setRejectedValue(error.getRejectedValue());
				errorDto.getFieldErrors().add(fieldErrorDto);
			});
		}
		return errorDto;
	}
}
