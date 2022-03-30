package com.marketlogic.survey.service.def.config;


import com.marketlogic.survey.model.dto.config.SurveyConfigDTO;
import com.marketlogic.survey.persistence.entity.config.SurveyConfig;

/**
 * Service Interface for CRUD operations related to {@link SurveyConfig}
 *
 * @author Naveen John
 */
public interface SurveyConfigService {
	
	/**
	 * Saves the Survey
	 * @param surveyDTO
	 * @return surveyDTO
	 */
	public SurveyConfigDTO saveSurvey(SurveyConfigDTO surveyDTO);

	/**
	 * Deletes the Survey
	 * @param surveyId
	 * @return
	 */
    void deleteSurveyById(long surveyId);
}
