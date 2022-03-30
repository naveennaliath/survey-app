package com.marketlogic.survey.constants;

public class APIPathConstants {
	
	public static final String BASE_API_PATH = "api/v1/survey";
	
	/**CRUD API Path**/
	public static final String CREATE_API_PATH = "/create";
	public static final String GET_API_PATH = "/get";
	public static final String UPDATE_API_PATH = "/update";
	public static final String DELETE_API_PATH = "/delete";
	
	public static final String PATH_VARIABLE_SURVEY_ID = "surveyId";
	
	/**Survey API path**/
	public static final String SURVEY_BASE_API_PATH = BASE_API_PATH;
	public static final String CREATE_SURVEY_API_PATH = SURVEY_BASE_API_PATH + CREATE_API_PATH;
	public static final String GET_SURVEY_API_PATH = SURVEY_BASE_API_PATH + GET_API_PATH+"/"+"{"+ PATH_VARIABLE_SURVEY_ID +"}";

	public static final String UPDATE_SURVEY_API_PATH = SURVEY_BASE_API_PATH + UPDATE_API_PATH;
	public static final String DELETE_SURVEY_API_PATH = SURVEY_BASE_API_PATH + DELETE_API_PATH+"/"+"{"+ PATH_VARIABLE_SURVEY_ID +"}";

	public static final String PATH_VARIABLE_QUESTION_ID = "questionId";

	/**Question API path**/
	public static final String QUESTION_BASE_API_PATH = BASE_API_PATH + "/question";
	public static final String CREATE_QUESTION_API_PATH = QUESTION_BASE_API_PATH + CREATE_API_PATH;
	public static final String GET_QUESTION_API_PATH = QUESTION_BASE_API_PATH + GET_API_PATH+"/"+"{"+ PATH_VARIABLE_SURVEY_ID +"}";
	public static final String GET_QUESTION_WITH_ANS_API_PATH = QUESTION_BASE_API_PATH + "/getWithAns/"+"{"+ PATH_VARIABLE_SURVEY_ID +"}";

	public static final String UPDATE_QUESTION_API_PATH = QUESTION_BASE_API_PATH + UPDATE_API_PATH;
	public static final String DELETE_QUESTION_API_PATH = QUESTION_BASE_API_PATH + DELETE_API_PATH+"/"+"{"+ PATH_VARIABLE_QUESTION_ID +"}";

	/**Survey Response API path**/
	public static final String SURVEY_SUBMISSION_BASE_API_PATH = BASE_API_PATH+ "/submission";
	public static final String CREATE_SURVEY_SUBMISSION_API_PATH = SURVEY_SUBMISSION_BASE_API_PATH + CREATE_API_PATH;

	/**Survey Report API path**/
	public static final String ANSWER_API_PATH = "/answer";
	public static final String DISTRIBUTION_API_PATH = "/distribution";
	public static final String SURVEY_REPORT_BASE_API_PATH = BASE_API_PATH+ "/report";
	public static final String GET_SURVEY_ANS_API_PATH = SURVEY_REPORT_BASE_API_PATH + ANSWER_API_PATH+"/"+"{"+ PATH_VARIABLE_SURVEY_ID +"}";
	public static final String GET_SURVEY_ANS_DISTRIBUTION_API_PATH = SURVEY_REPORT_BASE_API_PATH + DISTRIBUTION_API_PATH+"/"+"{"+ PATH_VARIABLE_SURVEY_ID +"}";


}
