package com.marketlogic.survey.model.rest.response.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.marketlogic.survey.model.dto.config.AnswerConfigDTO;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"questionOrder",
	"question",
	"questionDesc",
	"choiceType",
	"answerList"
	})
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionConfigResponse extends BaseResponse {

		private long id;

		private int questionOrder;

		private String question;

		private String questionDesc;

		private List<AnswerConfigDTO> answerList;

}

