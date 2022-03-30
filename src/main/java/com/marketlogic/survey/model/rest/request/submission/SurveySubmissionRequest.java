package com.marketlogic.survey.model.rest.request.submission;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marketlogic.survey.model.rest.request.BaseRequest;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmissionDetail;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * POJO to map Answer Request
 *
 * @author Naveen John
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveySubmissionRequest extends BaseRequest {

	private long surveyId;

	private String surveyName;

	private LocalDateTime submittedOn;

	private String submittedBy;

	private List<SurveySubmissionDetailRequest> submissionDetail;

}
