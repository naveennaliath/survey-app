package com.marketlogic.survey.service.def.report;


import com.marketlogic.survey.model.dto.report.SurveyDistributionDTO;
import com.marketlogic.survey.model.rest.response.config.SurveyConfigResponse;

/**
 * Service Interface for CRUD operations related to {@link SurveyConfigResponse}
 *
 * @author Naveen John
 */
public interface SurveyReportService {
    SurveyDistributionDTO getSurveyResponseDistribution(long surveyId);
}
