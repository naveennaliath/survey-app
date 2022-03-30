package com.marketlogic.survey.mapper.config;

import com.marketlogic.survey.model.dto.config.QuestionConfigDTO;
import com.marketlogic.survey.model.dto.config.QuestionConfigListDTO;
import com.marketlogic.survey.model.projection.config.QuestionProjection;
import com.marketlogic.survey.model.rest.request.config.QuestionConfigListRequest;
import com.marketlogic.survey.model.rest.request.config.QuestionConfigRequest;
import com.marketlogic.survey.model.rest.response.config.QuestionConfigListResponse;
import com.marketlogic.survey.persistence.entity.config.QuestionConfig;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) 
public interface QuestionConfigMapper {

	QuestionConfigListDTO convertQuestionListRequestToQuestionListDTO(QuestionConfigListRequest questionListRequest);

	QuestionConfigListResponse convertQuestionListDTOToQuestionListResponse(QuestionConfigListDTO questionListDTO);
	
	QuestionConfigDTO convertQuestionRequestToQuestionDTO(QuestionConfigRequest questionRequest);

	QuestionConfig convertQuestionDTOToQuestion(QuestionConfigDTO questionDTO);

	QuestionConfigDTO convertQuestionToQuestionDTO(QuestionConfig question);

	QuestionConfigDTO convertQuestionProjToQuestionDTO(QuestionProjection questionProjection);

}
