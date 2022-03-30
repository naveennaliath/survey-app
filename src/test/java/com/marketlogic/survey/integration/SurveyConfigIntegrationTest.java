package com.marketlogic.survey.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.marketlogic.survey.constants.APIPathConstants;
import com.marketlogic.survey.model.rest.request.config.SurveyConfigRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketlogic.survey.SurveyApplication;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

@SpringBootTest(
		webEnvironment =SpringBootTest.WebEnvironment.MOCK,
  classes = SurveyApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class SurveyConfigIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("Throws MandatoryFieldException when any of the mandatory fields are not provided")
	public void createSurvey_WhenMandatoryFieldsAreMissing_ThenShouldThrowMandatoryFieldException() throws Exception {

		// Setting up data
		var surveyConfigRequest = SurveyConfigRequest.builder()
				.surveyDescription("Survey Description").build();

		var surveyConfigRequestStr = objectMapper.writeValueAsString(surveyConfigRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/" + APIPathConstants.CREATE_SURVEY_API_PATH).content(surveyConfigRequestStr)
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(
						result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));


	}

}
