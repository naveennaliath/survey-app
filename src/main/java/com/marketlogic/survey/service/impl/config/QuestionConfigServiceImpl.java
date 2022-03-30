package com.marketlogic.survey.service.impl.config;

import com.marketlogic.survey.constants.MessageConstants;
import com.marketlogic.survey.exception.SurveyBusinessException;
import com.marketlogic.survey.mapper.config.QuestionConfigMapper;
import com.marketlogic.survey.mapper.config.SurveyConfigMapper;
import com.marketlogic.survey.model.dto.config.QuestionConfigListDTO;
import com.marketlogic.survey.persistence.repo.config.QuestionConfigRepository;
import com.marketlogic.survey.persistence.repo.config.SurveyConfigRepository;
import com.marketlogic.survey.persistence.entity.config.AnswerConfigList;
import com.marketlogic.survey.persistence.entity.config.QuestionConfig;
import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import com.marketlogic.survey.properties.CustomMessages;
import com.marketlogic.survey.service.def.config.QuestionConfigService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Service Implementation of {@link QuestionConfigService}
 *
 * @author Naveen John
 */
@Service
@Slf4j
@NoArgsConstructor
public class QuestionConfigServiceImpl implements QuestionConfigService {


	@Autowired
	private SurveyConfigRepository surveyConfigRepository;

	@Autowired
	private QuestionConfigRepository questionConfigRepository;

	@Autowired
	private QuestionConfigMapper questionConfigMapper;

	@Autowired
	private SurveyConfigMapper surveyConfigMapper;

	@Autowired
	private CustomMessages customMessages;

	@Override
	public QuestionConfigListDTO saveQuestions(QuestionConfigListDTO questionListDTO) throws SurveyBusinessException{

		log.info("Inside saveQuestions");

		log.debug("Invoking surveyConfigRepository.findById()");
		var survey = surveyConfigRepository.findById(questionListDTO.getId());
		if(survey.isPresent()) {
			for(var questionDto : questionListDTO.getQuestionList()) {
				var question = questionConfigMapper.convertQuestionDTOToQuestion(questionDto);

				var answerList = new AnswerConfigList();
				answerList.setAnswerList(questionDto.getAnswerList());
				question.setAnswer(answerList);

				question.setSurvey(survey.get());
				questionConfigRepository.save(question);
				questionDto.setId(question.getId());
			}

		} else {
			throw new SurveyBusinessException(
					customMessages.getMessage(MessageConstants.ERROR_QUESTION_LIST_NOT_FOUND, new String[] {String.valueOf(questionListDTO.getId())}));
		}
		log.info("Saved Questions. Converting to SurveyDTO and returning from saveQuestions");

		return questionListDTO;

	}

	@Override
	public Optional<QuestionConfigListDTO> getQuestionBySurveyId(long surveyId) {

		var questionList = questionConfigRepository.getQuestionOnlyBySurveyId(surveyId);
		if(!CollectionUtils.isEmpty(questionList)) {
			var questionListDTO = new QuestionConfigListDTO();
			questionListDTO.setQuestionList(new ArrayList<>());
			for(var question : questionList) {
				var questionDTO = questionConfigMapper.convertQuestionProjToQuestionDTO(question);
				questionListDTO.getQuestionList().add(questionDTO);
			}

			return Optional.of(questionListDTO);
		}

		return Optional.empty();

	}

	@Override
	public Optional<QuestionConfigListDTO> updateQuestions(QuestionConfigListDTO qtnListDTO) {
		{

			var questionList = questionConfigRepository.getQuestionBySurveyId(qtnListDTO.getId());

			if(!CollectionUtils.isEmpty(questionList)) {

				for (QuestionConfig question : questionList) {
					questionConfigRepository.delete(question);
				}

				for(var questionDto : qtnListDTO.getQuestionList()) {
					var question = questionConfigMapper.convertQuestionDTOToQuestion(questionDto);

					var answerList = new AnswerConfigList();
					answerList.setAnswerList(questionDto.getAnswerList());
					question.setAnswer(answerList);

					SurveyConfig survey = new SurveyConfig();
					survey.setId(qtnListDTO.getId());
					question.setSurvey(survey);
					questionConfigRepository.save(question);
					questionDto.setId(question.getId());
				}

				return Optional.of(qtnListDTO);
			}

			return Optional.empty();

		}
	}

	@Override
	public Optional<QuestionConfigListDTO> getQuestionWithAnsBySurveyId(long surveyId) {

		var questionList = questionConfigRepository.getQuestionBySurveyId(surveyId);
		if(!CollectionUtils.isEmpty(questionList)) {
			var questionListDTO = new QuestionConfigListDTO();
			questionListDTO.setQuestionList(new ArrayList<>());
			for(var question : questionList) {
				var questionDTO = questionConfigMapper.convertQuestionToQuestionDTO(question);
				questionDTO.setAnswerList(question.getAnswer().getAnswerList());
				questionListDTO.getQuestionList().add(questionDTO);
			}

			return Optional.of(questionListDTO);
		}

		return Optional.empty();

	}

}
