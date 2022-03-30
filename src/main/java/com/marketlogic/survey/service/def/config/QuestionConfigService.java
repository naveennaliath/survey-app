package com.marketlogic.survey.service.def.config;


import com.marketlogic.survey.model.dto.config.QuestionConfigListDTO;
import com.marketlogic.survey.persistence.entity.config.QuestionConfig;

import java.util.Optional;

/**
 * Service Interface for CRUD operations related to {@link QuestionConfig}
 *
 * @author Naveen John
 */
public interface QuestionConfigService {
	
	/**
	 * Saves questions against the survey id
	 * @param questionListDTO
	 * @return questionListDTO
	 */
	public QuestionConfigListDTO saveQuestions(QuestionConfigListDTO questionListDTO);

	/**
	 * Gets questions against the survey id
	 * @param surveyId
	 * @return Optional<QuestionListDTO>
	 */
	Optional<QuestionConfigListDTO> getQuestionBySurveyId(long surveyId);

	/**
	 * Updates questions against the survey id
	 * @param questionListDTO
	 * @return Optional<QuestionListDTO>
	 */
	Optional<QuestionConfigListDTO> updateQuestions(QuestionConfigListDTO questionListDTO);

	Optional<QuestionConfigListDTO> getQuestionWithAnsBySurveyId(long surveyId);
}
