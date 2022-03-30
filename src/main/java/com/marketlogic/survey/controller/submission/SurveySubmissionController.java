package com.marketlogic.survey.controller.submission;

import com.marketlogic.survey.constants.APIPathConstants;
import com.marketlogic.survey.mapper.submission.SurveySubmissionMapper;
import com.marketlogic.survey.model.rest.request.submission.SurveySubmissionRequest;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import com.marketlogic.survey.properties.CustomMessages;
import com.marketlogic.survey.service.def.submission.SurveySubmissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.MessageFormat;

import static com.marketlogic.survey.exception.ErrorDetails.Error.ErrorConstants;

/**
 * Controller Class for responding to a Survey, related to {@link SurveyConfig}
 *
 * @author Naveen John
 */

@RestController
@Slf4j
@Tag(name = "Survey Submission", description = "Endpoints for accessing/updating Survey")
public class SurveySubmissionController {

	@Autowired
	private SurveySubmissionService surveySubmissionService;

	@Autowired
	private SurveySubmissionMapper surveySubmissionMapper;

	@Autowired
	private CustomMessages customMessages;


	@PostMapping(value = APIPathConstants.CREATE_SURVEY_SUBMISSION_API_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Saves the submitted response.", responses = {
			@ApiResponse(responseCode = ErrorConstants.RECORD_CREATED_CODE),
			@ApiResponse(responseCode = ErrorConstants.MANDATORY_FIELDS_NOT_PRESENT_ERROR_CODE)})
	/**
	 * Saves the submitted response
	 *
	 * @param surveySubmissionRequest
	 * @return responseEntity
	 */
	public ResponseEntity<? extends BaseResponse> submitSurvey(@Valid @RequestBody SurveySubmissionRequest surveySubmissionRequest) {

		log.info("Inside createQuestion");
		log.debug(MessageFormat.format("Survey Submission Request : {1}", surveySubmissionRequest.toString()));

		log.debug("Invoking surveySubmissionService.submitSurvey()");
		surveySubmissionService.submitSurvey(surveySubmissionMapper.convertSurveySubmissionRequestToSurveySubmissionDTO(surveySubmissionRequest));

		log.info("Generating and returning response from submitSurvey");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
