package com.marketlogic.survey.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.marketlogic.survey.constants.APIPathConstants;
import com.marketlogic.survey.controller.config.SurveyConfigController;
import com.marketlogic.survey.mapper.config.SurveyConfigMapper;
import com.marketlogic.survey.model.dto.config.SurveyConfigDTO;
import com.marketlogic.survey.model.rest.request.config.SurveyConfigRequest;
import com.marketlogic.survey.model.rest.response.config.SurveyConfigResponse;
import com.marketlogic.survey.service.def.config.SurveyConfigService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.marketlogic.survey.properties.CustomMessages;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

@WebMvcTest(controllers = SurveyConfigController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(SpringExtension.class)
public class SurveyConfigControllerTest {

	private static final Long SURVEY_ID = 1L;

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	@MockBean
	private SurveyConfigService surveyConfigService;

	@MockBean
	private SurveyConfigMapper surveyConfigMapper;

	@TestConfiguration
	static class TestConfig {
		@Bean
		CustomMessages getMyCustomMessages() {
			return new CustomMessages();
		}
	}

	@Test
	@DisplayName("Throws MandatoryFieldException when any of the mandatory fields are not provided")
	public void createSurvey_WhenMandatoryFieldsAreMissing_ThenShouldThrowMandatoryFieldException() throws Exception {

		// Setting up data
		var surveyConfigRequest = SurveyConfigRequest.builder().build();

		var surveyRequestStr = objectMapper.writeValueAsString(surveyConfigRequest);


		// Invoking API and asserting
		mockMvc.perform(MockMvcRequestBuilders.post("/" + APIPathConstants.CREATE_SURVEY_API_PATH)
						.content(surveyRequestStr).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(
						result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));

	}

	@Test
	@DisplayName("Creates Survey when all mandatory fields are provided")
	public void createSurvey_WhenMandatoryFieldsArePresent_ThenShouldCreateSurvey() throws Exception {

		// Setting up data
		var surveyConfigRequest = SurveyConfigRequest.builder()
		.surveyName("Survey Name").surveyDescription("Survey Description").build();

		var surveyConfigRequestStr = objectMapper.writeValueAsString(surveyConfigRequest);

		// Mocking
		when(surveyConfigService.saveSurvey(Mockito.any(SurveyConfigDTO.class)))
				.thenReturn(SurveyConfigDTO.builder().id(SURVEY_ID).build());

		when(surveyConfigMapper.convertSurveyRequestToSurveyDTO(Mockito.any(SurveyConfigRequest.class)))
				.thenReturn(SurveyConfigDTO.builder().surveyName("Survey Name").surveyDescription("Survey Description").build());

		when(surveyConfigMapper.convertSurveyDTOToSurveyResponse(Mockito.any(SurveyConfigDTO.class)))
				.thenReturn(SurveyConfigResponse.builder().id(SURVEY_ID).build());

		// Invoking API and asserting
		MvcResult mvcResult = mockMvc.perform(
						MockMvcRequestBuilders.post("/" + APIPathConstants.CREATE_SURVEY_API_PATH)
								.content(surveyConfigRequestStr)
								.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();

		String contentStr = mvcResult.getResponse().getContentAsString();
		assertNotNull(contentStr);
		var surveyConfigResponse = objectMapper.readValue(contentStr, SurveyConfigResponse.class);
		assertNotNull(surveyConfigResponse.getId());

	}

	 

}
