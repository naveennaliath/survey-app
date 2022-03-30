package com.marketlogic.survey.model.dto.config;

import java.util.List;

import com.marketlogic.survey.model.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class SurveyConfigDTO extends BaseDTO {

	private long id;

	private String surveyName;

	private String surveyDescription;

	private List<QuestionConfigDTO> questionList;

}