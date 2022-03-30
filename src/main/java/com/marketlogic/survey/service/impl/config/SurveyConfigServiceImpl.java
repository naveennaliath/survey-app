package com.marketlogic.survey.service.impl.config;

import com.marketlogic.survey.constants.MessageConstants;
import com.marketlogic.survey.exception.SurveyBusinessException;
import com.marketlogic.survey.mapper.config.SurveyConfigMapper;
import com.marketlogic.survey.model.dto.config.SurveyConfigDTO;
import com.marketlogic.survey.persistence.repo.config.SurveyConfigRepository;
import com.marketlogic.survey.properties.CustomMessages;
import com.marketlogic.survey.service.def.config.SurveyConfigService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Implementation of {@link SurveyConfigService}
 *
 * @author Naveen John
 */
@Service
@Slf4j
@NoArgsConstructor
public class SurveyConfigServiceImpl implements SurveyConfigService {

	@Autowired
	private SurveyConfigRepository surveyRepository;

	@Autowired
	private SurveyConfigMapper surveyConfigMapper;

	@Autowired
	private CustomMessages customMessages;

	@Override
	public SurveyConfigDTO saveSurvey(SurveyConfigDTO surveyDTO) {

		log.info("Inside saveSurvey");

		log.debug("Invoking surveyRepository.save()");
		var survey = surveyRepository.save(surveyConfigMapper.convertSurveyDTOToSurvey(surveyDTO));
		log.info("Saved Survey. Converting to SurveyDTO and returning from saveSurvey");

		return surveyConfigMapper.convertSurveyToSurveyDTO(survey);

	}

	@Override
	public void deleteSurveyById(long surveyId) {

		var survey = surveyRepository.findById(surveyId);
		if(survey.isPresent()) {
			surveyRepository.deleteById(surveyId);
		} else {
			throw new SurveyBusinessException(
					customMessages.getMessage(MessageConstants.ERROR_SURVEY_NOT_FOUND, new String[]{String.valueOf(surveyId)}));
		}
	}

}
