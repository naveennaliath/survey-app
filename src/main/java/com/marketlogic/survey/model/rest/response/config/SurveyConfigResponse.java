package com.marketlogic.survey.model.rest.response.config;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.marketlogic.survey.model.dto.config.QuestionConfigDTO;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"surveyName",
	"surveyDescription"
	})
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyConfigResponse extends BaseResponse {

	@JsonProperty(value = "surveyId")
	private long id;

	private String surveyName;

	private String surveyDescription;

}
