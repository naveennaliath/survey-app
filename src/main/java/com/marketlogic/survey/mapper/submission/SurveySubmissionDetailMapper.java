package com.marketlogic.survey.mapper.submission;

import com.marketlogic.survey.model.dto.config.QuestionConfigDTO;
import com.marketlogic.survey.model.dto.config.QuestionConfigListDTO;
import com.marketlogic.survey.model.dto.submission.SurveySubmissionDTO;
import com.marketlogic.survey.model.dto.submission.SurveySubmissionDetailDTO;
import com.marketlogic.survey.model.projection.config.QuestionProjection;
import com.marketlogic.survey.model.rest.request.config.QuestionConfigListRequest;
import com.marketlogic.survey.model.rest.request.config.QuestionConfigRequest;
import com.marketlogic.survey.model.rest.response.config.QuestionConfigListResponse;
import com.marketlogic.survey.persistence.entity.config.QuestionConfig;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmission;
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
public interface SurveySubmissionDetailMapper {


	@Mapping(source = "answerList", target = "surveySubmissionAnswerList", qualifiedByName = "answerListToSurveySubmissionAnswerList")
	public SurveySubmissionDetail convertSurveySubmissionDetailDTOToSurveySubmissionDetail(SurveySubmissionDetailDTO surveySubmissionDetailDTO);

	@Named("answerListToSurveySubmissionAnswerList")
	public static List<SurveySubmissionAnswer> answerListToSurveySubmissionAnswerList(List<String> answerList) {
		if(CollectionUtils.isEmpty(answerList)) {
			return new ArrayList<>();
		} else {
			var surveySubmissionAnswerList = new ArrayList<SurveySubmissionAnswer>();
			for(String ans : answerList) {
				surveySubmissionAnswerList.add(SurveySubmissionAnswer.builder().answer(ans).build());
			}

			return surveySubmissionAnswerList;
		}
	}

	@Mapping(source = "surveySubmissionAnswerList", target = "answerList", qualifiedByName = "surveySubmissionAnswerListToAnswerList")
	public SurveySubmissionDetailDTO convertSurveySubmissionDetailDTOToSurveySubmissionDetail(SurveySubmissionDetail surveySubmissionDetail);

	@Named("surveySubmissionAnswerListToAnswerList")
	public static List<String> surveySubmissionAnswerListToAnswerList(List<SurveySubmissionAnswer> surveySubmissionAnswerList) {
		if(CollectionUtils.isEmpty(surveySubmissionAnswerList)) {
			return new ArrayList<>();
		} else {
			return surveySubmissionAnswerList.stream().map(SurveySubmissionAnswer::getAnswer).collect(Collectors.toList());
		}
	}


}
