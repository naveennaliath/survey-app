package com.marketlogic.survey.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
public class ErrorDetails {

	@Getter
	@ToString
	@AllArgsConstructor
	public static enum Error {
		MANDATORY_FIELDS_NOT_PRESENT(ErrorConstants.MANDATORY_FIELDS_NOT_PRESENT_ERROR_CODE);
		public static class ErrorConstants {
	        public static final String SUCCESS_CODE = "200";
	        public static final String RECORD_CREATED_CODE = "201";
	        public static final String SURVEY_NOT_FOUND_ERROR_CODE = "400";
			public static final String QUESTION_NOT_FOUND_ERROR_CODE = "400";
	        public static final String APPLICATION_ERROR_CODE = "E101";
	    	public static final String MANDATORY_FIELDS_NOT_PRESENT_ERROR_CODE = "E102";
	    	
	    }
		
		private String code;

	}

	private String errorCode;

	private String errorMessage;
}
