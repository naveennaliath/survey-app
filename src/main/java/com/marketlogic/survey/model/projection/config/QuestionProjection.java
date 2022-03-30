package com.marketlogic.survey.model.projection.config;

/**
 * DTO for Survey
 *
 * @author Naveen John
 */

public interface QuestionProjection{

	long getId();

	int getQuestionOrder();

	String getQuestion();

	String getQuestionDesc();

}