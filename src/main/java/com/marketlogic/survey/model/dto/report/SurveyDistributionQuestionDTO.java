package com.marketlogic.survey.model.dto.report;

import com.marketlogic.survey.model.dto.BaseDTO;
import com.marketlogic.survey.model.dto.submission.SurveySubmissionDetailDTO;
import lombok.*;

import java.time.LocalDateTime;
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
public class SurveyDistributionQuestionDTO extends BaseDTO {

	private String question;

	private List<SurveyDistributionAnswerDTO> answerDetail;

}
