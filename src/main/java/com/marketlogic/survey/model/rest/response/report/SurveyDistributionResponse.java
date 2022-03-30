package com.marketlogic.survey.model.rest.response.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marketlogic.survey.model.dto.report.SurveyDistributionQuestionDTO;
import com.marketlogic.survey.model.rest.request.BaseRequest;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import lombok.Data;

import java.util.List;

/**
 * POJO to map Answer Request
 *
 * @author Naveen John
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyDistributionResponse extends BaseResponse {

	private long surveyId;

	private String surveyName;

	private List<SurveyDistributionQuestionResponse> distributionDetail;

}
