package com.marketlogic.survey.model.dto.submission;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marketlogic.survey.model.dto.BaseDTO;
import com.marketlogic.survey.model.rest.request.BaseRequest;
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
public class SurveySubmissionDetailDTO extends BaseDTO {

	private String question;

	private String questionDesc;

	private List<String> answerList;

}
