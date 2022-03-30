package com.marketlogic.survey.mapper.submission;

import com.marketlogic.survey.model.dto.submission.SurveySubmissionDTO;
import com.marketlogic.survey.model.dto.submission.SurveySubmissionDetailDTO;
import com.marketlogic.survey.model.rest.request.submission.SurveySubmissionRequest;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmissionAnswer;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmissionDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) 
public interface SurveySubmissionMapper {

	public SurveySubmissionDTO convertSurveySubmissionRequestToSurveySubmissionDTO(SurveySubmissionRequest surveySubmissionRequest);

}
