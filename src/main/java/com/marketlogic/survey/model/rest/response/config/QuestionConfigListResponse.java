package com.marketlogic.survey.model.rest.response.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id"
	})
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionConfigListResponse extends BaseResponse {

	/**Survey Id**/
	@JsonProperty(value = "surveyId")
	private long id;

	private List<QuestionConfigResponse> questionList;
}
