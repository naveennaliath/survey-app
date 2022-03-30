package com.marketlogic.survey.mapper.report;

import com.marketlogic.survey.model.dto.report.SurveyDistributionDTO;
import com.marketlogic.survey.model.dto.submission.SurveySubmissionDTO;
import com.marketlogic.survey.model.rest.request.submission.SurveySubmissionRequest;
import com.marketlogic.survey.model.rest.response.report.SurveyDistributionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) 
public interface SurveyReportMapper {

	public SurveySubmissionDTO convertSurveySubmissionRequestToSurveySubmissionDTO(SurveySubmissionRequest surveySubmissionRequest);

	SurveyDistributionResponse convertSurveyDistributionDTOToSurveyDistributionResponse(SurveyDistributionDTO surveyDistributionDTO);
}
