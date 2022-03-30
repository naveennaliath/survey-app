package com.marketlogic.survey.model.rest.request.submission;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marketlogic.survey.model.rest.request.BaseRequest;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * POJO to map Answer Request
 *
 * @author Naveen John
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveySubmissionDetailRequest extends BaseRequest {

	private String question;

	private String questionDesc;

	private List<String> answerList;

}
