package com.marketlogic.survey.exception;

import java.text.MessageFormat;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(SurveyBusinessException.class)
	public ResponseEntity<?> handleBusinessException(SurveyBusinessException ex) {
		log.error(ex.getMessage(),ex);
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(ErrorDetails.Error.ErrorConstants.APPLICATION_ERROR_CODE);
		errorDetails.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		log.error(ex.getMessage(),ex);
		String mandatoryFields = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getField)
				.collect(Collectors.joining(","));

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(ErrorDetails.Error.ErrorConstants.MANDATORY_FIELDS_NOT_PRESENT_ERROR_CODE);
		errorDetails
				.setErrorMessage(MessageFormat.format("Following mandatory fields are missing : {0}", mandatoryFields));
		return new ResponseEntity<>(errorDetails, HttpStatus.OK);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
		log.error(ex.getMessage(),ex);
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(ErrorDetails.Error.ErrorConstants.APPLICATION_ERROR_CODE);
		errorDetails.setErrorMessage("Request Failed. Please try again or contact support");
		return new ResponseEntity<>(errorDetails, HttpStatus.OK);

	}

}