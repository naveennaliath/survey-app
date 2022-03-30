package com.marketlogic.survey.model.rest.response.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marketlogic.survey.model.dto.BaseDTO;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import lombok.*;

import java.util.List;

/**
 * POJO to map Answer Request
 *
 * @author Naveen John
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyDistributionQuestionResponse extends BaseResponse {

	private String question;

	private List<SurveyDistributionAnswerResponse> answerDetail;

}
