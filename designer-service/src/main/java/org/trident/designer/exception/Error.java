package org.trident.designer.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder(value = {
		"errorCode",
		"errorMessage",
		"fieldErrors"
})
public class Error {

	@JsonProperty("errorCode")
	private int errorCode;
	@JsonProperty("errorMessage")
	private String errorMessage;
	@JsonProperty("fieldErrors")
	private List<FieldError> fieldErrors = new ArrayList<>();
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(final int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(final List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
}
