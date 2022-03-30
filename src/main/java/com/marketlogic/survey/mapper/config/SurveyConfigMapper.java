package com.marketlogic.survey.mapper.config;

import com.marketlogic.survey.model.dto.config.SurveyConfigDTO;
import com.marketlogic.survey.model.rest.response.config.SurveyConfigResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.marketlogic.survey.model.rest.request.config.SurveyConfigRequest;
import com.marketlogic.survey.persistence.entity.config.SurveyConfig;

@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) 
public interface SurveyConfigMapper {
	
	SurveyConfigDTO convertSurveyRequestToSurveyDTO(SurveyConfigRequest surveyRequest);

	SurveyConfig convertSurveyDTOToSurvey(SurveyConfigDTO surveyConfigDTO);
	
	SurveyConfigDTO convertSurveyToSurveyDTO(SurveyConfig survey);
	
	SurveyConfigResponse convertSurveyDTOToSurveyResponse(SurveyConfigDTO surveyDTO);
}
