package com.marketlogic.survey.model.rest.response.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"header",
	"shortDescription",
	"text",
	"keywords",
	"authors",
	"publishDate"
	})
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerConfigResponse extends BaseResponse {

	private String answer;

}
