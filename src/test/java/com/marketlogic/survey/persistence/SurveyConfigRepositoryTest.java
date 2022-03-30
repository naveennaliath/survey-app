package com.marketlogic.survey.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import com.marketlogic.survey.persistence.repo.config.SurveyConfigRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class SurveyConfigRepositoryTest {
	
	@Autowired
	SurveyConfigRepository surveyConfigRepository;

	@Test
	@DisplayName("Saves the Survey")
	public void saveSurvey_WhenSaved_ThenShouldCreateTheSurvey() {
		var surveyConfig = SurveyConfig.builder()
				.surveyName("Survey Name")
				.surveyDescription("Survey Desc").build();
		surveyConfig = surveyConfigRepository.save(surveyConfig);

		assertThat(surveyConfigRepository.findById(surveyConfig.getId())).isNotEmpty();

	}


}
