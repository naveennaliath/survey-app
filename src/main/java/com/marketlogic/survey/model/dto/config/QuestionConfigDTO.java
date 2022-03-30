package com.marketlogic.survey.model.dto.config;

import com.marketlogic.survey.model.dto.BaseDTO;
import lombok.*;

import java.util.List;

/**
 * DTO for Survey
 *
 * @author Naveen John
 */
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionConfigDTO extends BaseDTO {

	private long id;

	private long surveyId;

	private int questionOrder;

	private String question;

	private String questionDesc;

	private List<AnswerConfigDTO> answerList;

}