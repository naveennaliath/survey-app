package com.marketlogic.survey.service.def.submission;


import com.marketlogic.survey.model.dto.submission.SurveySubmissionDTO;
import com.marketlogic.survey.model.rest.response.config.SurveyConfigResponse;

/**
 * Service Interface for CRUD operations related to {@link SurveyConfigResponse}
 *
 * @author Naveen John
 */
public interface SurveySubmissionService {
    void submitSurvey(SurveySubmissionDTO surveySubmissionDTO);
}
