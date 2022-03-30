package com.marketlogic.survey.model.projection.report;

/**
 * DTO for Survey
 *
 * @author Naveen John
 */

public interface SurveyDistributionProjection {

	String getSurveyName();

	String getQuestion();

	String getAnswer();

	int getTotal();

	double getPercentage();

}