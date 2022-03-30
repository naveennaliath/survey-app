package com.marketlogic.survey.model.rest.response.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marketlogic.survey.model.dto.BaseDTO;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import lombok.*;

/**
 * POJO to map Answer Request
 *
 * @author Naveen John
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyDistributionAnswerResponse extends BaseResponse {

	private String answer;

	private double relativeDistribution;

}
