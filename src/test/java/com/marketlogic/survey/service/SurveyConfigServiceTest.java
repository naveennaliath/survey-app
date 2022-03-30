package com.marketlogic.survey.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.marketlogic.survey.model.dto.config.SurveyConfigDTO;
import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import com.marketlogic.survey.service.def.config.SurveyConfigService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.marketlogic.survey.persistence.repo.config.SurveyConfigRepository;

@SpringBootTest
public class SurveyConfigServiceTest {

	@MockBean
	private SurveyConfigRepository surveyConfigRepository;

	@Autowired
	private SurveyConfigService surveyConfigService;

	@Test
	@DisplayName("Saves the survey")
	public void saveSurvey_WhenSaved_ThenShouldCreateTheSurvey() {

		var surveyConfigDTO = SurveyConfigDTO.builder().surveyName("Survey Name")
				.surveyDescription("Survey Desc").build();

		var surveyConfig = SurveyConfig.builder().surveyName("Survey Name")
				.surveyDescription("Survey Desc").build();

		when(surveyConfigRepository.save(Mockito.any(SurveyConfig.class))).thenReturn(surveyConfig);

		SurveyConfigDTO surveyConfigDTOResult = surveyConfigService.saveSurvey(surveyConfigDTO);
		assertNotNull(surveyConfigDTOResult);
		assertEquals(surveyConfigDTOResult.getSurveyName(),surveyConfigDTOResult.getSurveyName());


	}

}
