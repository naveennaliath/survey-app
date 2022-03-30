package com.marketlogic.survey.controller.config;

import com.marketlogic.survey.constants.APIPathConstants;
import com.marketlogic.survey.exception.ErrorDetails;
import com.marketlogic.survey.mapper.config.SurveyConfigMapper;
import com.marketlogic.survey.model.rest.request.config.SurveyConfigRequest;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import com.marketlogic.survey.model.rest.response.config.SurveyConfigResponse;
import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import com.marketlogic.survey.properties.CustomMessages;
import com.marketlogic.survey.service.def.config.SurveyConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.MessageFormat;

import static com.marketlogic.survey.exception.ErrorDetails.Error.ErrorConstants;

/**
 * Controller Class defining APIs for CRUD operations related to {@link SurveyConfig}
 *
 * @author Naveen John
 */

@RestController
@Slf4j
@Tag(name = "Survey/Question Configuration", description = "Endpoints for accessing/updating Survey")
public class SurveyConfigController {

	@Autowired
	private SurveyConfigService surveyConfigService;

	@Autowired
	private SurveyConfigMapper surveyMapper;

	@Autowired
	private CustomMessages customMessages;

	@PostMapping(value = APIPathConstants.CREATE_SURVEY_API_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Creates a Survey", responses = {
			@ApiResponse(responseCode = ErrorDetails.Error.ErrorConstants.RECORD_CREATED_CODE, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = ErrorDetails.Error.ErrorConstants.MANDATORY_FIELDS_NOT_PRESENT_ERROR_CODE)})
	/**
	 * Creates a Survey
	 * 
	 * @param surveyRequest
	 * @return responseEntity
	 */
	public ResponseEntity<? extends BaseResponse> createSurvey(@Valid @RequestBody SurveyConfigRequest surveyRequest) {

		log.info("Inside createSurvey");
		log.debug(MessageFormat.format("Survey Request : {1}", surveyRequest.toString()));

		log.debug("Invoking surveyService.saveSurvey()");
		var surveyDTO = surveyConfigService.saveSurvey(surveyMapper.convertSurveyRequestToSurveyDTO(surveyRequest));

		log.info("Generating and returning response from saveSurvey");
		return new ResponseEntity<SurveyConfigResponse>(surveyMapper.convertSurveyDTOToSurveyResponse(surveyDTO),
				HttpStatus.CREATED);
	}

	@DeleteMapping(value = APIPathConstants.DELETE_SURVEY_API_PATH)
	@Operation(summary = "Deletes the survey", responses = {
			@ApiResponse(responseCode = ErrorConstants.RECORD_CREATED_CODE)})
	/**
	 * Deletes the survey
	 *
	 * @param surveyId
	 * @return responseEntity
	 */
	public ResponseEntity<?> deleteSurvey(@PathVariable(APIPathConstants.PATH_VARIABLE_SURVEY_ID) long surveyId) {
		log.info("Inside deleteSurvey");
		log.debug(MessageFormat.format("Survey Id : {1}", surveyId));

		surveyConfigService.deleteSurveyById(surveyId);

		return new ResponseEntity<>(new SurveyConfigResponse(), HttpStatus.NO_CONTENT);

	}

}
