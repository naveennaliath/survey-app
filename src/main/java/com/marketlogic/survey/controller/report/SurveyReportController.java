package com.marketlogic.survey.controller.report;

import com.marketlogic.survey.constants.APIPathConstants;
import com.marketlogic.survey.constants.MessageConstants;
import com.marketlogic.survey.exception.ErrorDetails;
import com.marketlogic.survey.exception.SurveyBusinessException;
import com.marketlogic.survey.mapper.report.SurveyReportMapper;
import com.marketlogic.survey.mapper.submission.SurveySubmissionMapper;
import com.marketlogic.survey.model.rest.response.BaseResponse;
import com.marketlogic.survey.model.rest.response.report.SurveyDistributionResponse;
import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import com.marketlogic.survey.service.def.report.SurveyReportService;
import com.marketlogic.survey.service.def.submission.SurveySubmissionService;
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

import java.text.MessageFormat;

/**
 * Controller Class defining APIs for CRUD operations related to {@link SurveyConfig}
 *
 * @author Naveen John
 */

@RestController
@Slf4j
@Tag(name = "Survey Report", description = "Endpoints for getting Survey report")
public class SurveyReportController {


    @Autowired
    private SurveyReportService surveyReportService;

    @Autowired
    private SurveyReportMapper surveyReportMapper;

    /**
     * Gets all questions for a specific survey
     *
     * @param surveyId
     * @return responseEntity
     */
    @GetMapping(value = APIPathConstants.GET_SURVEY_ANS_DISTRIBUTION_API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Gets the relative distribution of answers.", responses = {
            @ApiResponse(responseCode = ErrorDetails.Error.ErrorConstants.SURVEY_NOT_FOUND_ERROR_CODE, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    public ResponseEntity<? extends BaseResponse> getSurveyResponseDistribution(
            @PathVariable(APIPathConstants.PATH_VARIABLE_SURVEY_ID) long surveyId) {
        log.info("Inside getSurveyResponseDistribution");
        log.debug(MessageFormat.format("Survey Id : {1}", surveyId));

        var surveyDistributionDTO = surveyReportService.getSurveyResponseDistribution(surveyId);

        log.info("Generating and returning response from getQuestionBySurveyId");
        return new ResponseEntity<SurveyDistributionResponse>(surveyReportMapper.convertSurveyDistributionDTOToSurveyDistributionResponse(surveyDistributionDTO),
                HttpStatus.OK);

    }

}
