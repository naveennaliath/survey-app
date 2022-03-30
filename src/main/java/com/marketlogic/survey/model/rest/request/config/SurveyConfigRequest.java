package com.marketlogic.survey.model.rest.request.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.marketlogic.survey.model.rest.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * POJO to map Survey Config Request
 *
 * @author Naveen John
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyConfigRequest extends BaseRequest {

	@JsonProperty(value = "surveyId")
	private String id;

	@NotBlank(message = "Please provide survey name.")
	private String surveyName;

	@NotBlank(message = "Please provide survey description.")
	private String surveyDescription;

}