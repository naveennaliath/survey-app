package com.marketlogic.survey.model.rest.request.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marketlogic.survey.model.rest.request.BaseRequest;
import lombok.*;

import java.util.List;

/**
 * POJO to map QuestionListRequest
 *
 * @author Naveen John
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionConfigListRequest extends BaseRequest {

	@JsonProperty(value = "surveyId")
	private String id;

	private List<QuestionConfigRequest> questionList;

}