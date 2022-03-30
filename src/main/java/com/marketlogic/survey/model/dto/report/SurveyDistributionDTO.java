package com.marketlogic.survey.model.dto.report;

import com.marketlogic.survey.model.dto.BaseDTO;
import lombok.*;

import java.util.List;

/**
 * POJO to map Answer Request
 *
 * @author Naveen John
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDistributionDTO extends BaseDTO {

	private long surveyId;

	private String surveyName;

	private List<SurveyDistributionQuestionDTO> distributionDetail;

}
