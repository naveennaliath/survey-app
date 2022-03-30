package com.marketlogic.survey.controller.config;

import com.marketlogic.survey.constants.APIPathConstants;
import com.marketlogic.survey.constants.MessageConstants;
import com.marketlogic.survey.exception.ErrorDetails;
import com.marketlogic.survey.exception.SurveyBusinessException;
import com.marketlogic.survey.mapper.config.QuestionConfigMapper;
import com.marketlogic.survey.mapper.config.SurveyConfigMapper;
import com.marketlogic.survey.model.rest.request.config.QuestionConfigListRequest;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import com.marketlogic.survey.model.rest.response.config.QuestionConfigListResponse;
import com.marketlogic.survey.persistence.entity.config.QuestionConfig;
import com.marketlogic.survey.properties.CustomMessages;
import com.marketlogic.survey.service.def.config.QuestionConfigService;
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
 * Controller Class defining APIs for CRUD operations related to {@link QuestionConfig}
 *
 * @author Naveen John
 */

@RestController
@Slf4j
@Tag(name = "Survey/Question Configuration", description = "Endpoints for accessing/updating Questions")
public class QuestionConfigController {

    @Autowired
    private QuestionConfigService questionConfigService;

    @Autowired
    private SurveyConfigMapper surveyConfigMapper;

    @Autowired
    private QuestionConfigMapper questionConfigMapper;

    @Autowired
    private CustomMessages customMessages;

    @PostMapping(value = APIPathConstants.CREATE_QUESTION_API_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Creates a	Question.", responses = {
            @ApiResponse(responseCode = ErrorConstants.RECORD_CREATED_CODE, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = ErrorConstants.MANDATORY_FIELDS_NOT_PRESENT_ERROR_CODE)})
    /**
     * Creates Questions against Survey.
     * Can use to create single/multiple questions
     *
     * @param surveyRequest
     * @return responseEntity
     */
    public ResponseEntity<? extends BaseResponse> createQuestion(@Valid @RequestBody QuestionConfigListRequest questionListRequest) {

        log.info("Inside createQuestion");
        log.debug(MessageFormat.format("Question List Request : {1}", questionListRequest.toString()));

        log.debug("Invoking questionConfigService.saveQuestions()");
        var questionListDTO = questionConfigService.saveQuestions(questionConfigMapper.convertQuestionListRequestToQuestionListDTO(questionListRequest));

        log.info("Generating and returning response from createQuestion");
        return new ResponseEntity<QuestionConfigListResponse>(questionConfigMapper.convertQuestionListDTOToQuestionListResponse(questionListDTO),
                HttpStatus.CREATED);
    }

    /**
     * Gets all questions for a specific survey
     *
     * @param surveyId
     * @return responseEntity
     */
    @GetMapping(value = APIPathConstants.GET_QUESTION_API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Gets list of questions.", responses = {
            @ApiResponse(responseCode = ErrorDetails.Error.ErrorConstants.SURVEY_NOT_FOUND_ERROR_CODE, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<? extends BaseResponse> getQuestionBySurveyId(
            @PathVariable(APIPathConstants.PATH_VARIABLE_SURVEY_ID) long surveyId) {
        log.info("Inside getQuestionBySurveyId");
        log.debug(MessageFormat.format("Survey Id : {1}", surveyId));

        var questionListDTO = questionConfigService.getQuestionBySurveyId(surveyId);

        if (questionListDTO.isPresent()) {
            log.info("Generating and returning response from getQuestionBySurveyId");
            return new ResponseEntity<>(questionConfigMapper.convertQuestionListDTOToQuestionListResponse(questionListDTO.get()),
                    HttpStatus.OK);
        } else {
            throw new SurveyBusinessException(
                    customMessages.getMessage(MessageConstants.ERROR_QUESTION_LIST_NOT_FOUND, new String[]{String.valueOf(surveyId)}));
        }

    }


    /**
     * Gets all questions for a specific survey
     *
     * @param surveyId
     * @return responseEntity
     */
    @GetMapping(value = APIPathConstants.GET_QUESTION_WITH_ANS_API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Gets list of questions with answer.", responses = {
            @ApiResponse(responseCode = ErrorDetails.Error.ErrorConstants.SURVEY_NOT_FOUND_ERROR_CODE, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<? extends BaseResponse> getQuestionWithAnsBySurveyId(
            @PathVariable(APIPathConstants.PATH_VARIABLE_SURVEY_ID) long surveyId) {
        log.info("Inside getQuestionWithAnsBySurveyId");
        log.debug(MessageFormat.format("Survey Id : {1}", surveyId));

        var questionListDTO = questionConfigService.getQuestionWithAnsBySurveyId(surveyId);

        if (questionListDTO.isPresent()) {
            log.info("Generating and returning response from getQuestionBySurveyId");
            return new ResponseEntity<>(questionConfigMapper.convertQuestionListDTOToQuestionListResponse(questionListDTO.get()),
                    HttpStatus.OK);
        } else {
            throw new SurveyBusinessException(
                    customMessages.getMessage(MessageConstants.ERROR_QUESTION_LIST_NOT_FOUND, new String[]{String.valueOf(surveyId)}));
        }

    }

    @PatchMapping(value = APIPathConstants.UPDATE_QUESTION_API_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updates questions for a Survey Id. " +
            "Delete can also be handled by this API as this API expects complete list of questions for a survey", responses = {
            @ApiResponse(responseCode = ErrorConstants.SUCCESS_CODE, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = ErrorConstants.QUESTION_NOT_FOUND_ERROR_CODE)})
    /**
     * Updates questions for a Survey Id
     *
     * @param questionListRequest
     * @return responseEntity
     */
    public ResponseEntity<? extends BaseResponse> updateQuestions(@RequestBody QuestionConfigListRequest questionListRequest) {
        log.info("Inside updateQuestions");
        log.debug(MessageFormat.format("Questions", questionListRequest));

        var questionConfigListDTO = questionConfigService
                .updateQuestions(questionConfigMapper.convertQuestionListRequestToQuestionListDTO(questionListRequest));
        if (questionConfigListDTO.isPresent()) {
            log.info("Generating and returning response from updateQuestions");
            return new ResponseEntity<>(questionConfigMapper.convertQuestionListDTOToQuestionListResponse(questionConfigListDTO.get()),
                    HttpStatus.OK);
        } else {
            throw new SurveyBusinessException(
                    customMessages.getMessage(MessageConstants.ERROR_SURVEY_NOT_FOUND, new String[]{questionListRequest.getId()}));
        }

    }

}
