package com.marketlogic.survey.model.rest.request.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marketlogic.survey.model.rest.request.BaseRequest;
import lombok.Data;

/**
 * POJO to map Answer Request
 *
 * @author Naveen John
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerConfigRequest extends BaseRequest {

	private String answer;

}
