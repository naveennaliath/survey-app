package com.marketlogic.survey.exception;

/**
 * The SurveyBusinessException is thrown in case of any error related to application logic
 * 
 * @author NaveenJohn
 */

public class SurveyBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param errorMessage
	 */
	public SurveyBusinessException(String errorMessage) {

		super(errorMessage);
	}
	
	public SurveyBusinessException() {
		super();
	}
}