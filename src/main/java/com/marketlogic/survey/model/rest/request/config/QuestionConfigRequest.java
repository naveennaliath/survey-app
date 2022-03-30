package com.marketlogic.survey.model.rest.request.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.marketlogic.survey.model.rest.request.BaseRequest;
import lombok.Data;

import java.util.List;

/**
 * POJO to map Question Request
 *
 * @author Naveen John
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionConfigRequest extends BaseRequest {

	private Long id;

	private Integer questionOrder;

	private String question;

	private String questionDesc;

	private List<AnswerConfigRequest> answerList;

}
