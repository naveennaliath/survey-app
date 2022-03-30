package com.marketlogic.survey.service.impl.submission;

import com.marketlogic.survey.mapper.config.SurveyConfigMapper;
import com.marketlogic.survey.mapper.submission.SurveySubmissionDetailMapper;
import com.marketlogic.survey.model.dto.submission.SurveySubmissionDTO;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmission;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmissionDetail;
import com.marketlogic.survey.persistence.repo.config.SurveyConfigRepository;
import com.marketlogic.survey.persistence.repo.submission.SurveySubmissionRepository;
import com.marketlogic.survey.service.def.submission.SurveySubmissionService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Service Implementation of {@link SurveySubmissionService}
 *
 * @author Naveen John
 */
@Service
@Slf4j
@NoArgsConstructor
public class SurveySubmissionServiceImpl implements SurveySubmissionService {

    @Autowired
    private SurveySubmissionRepository surveySubmissionRepository;

    @Autowired
    private SurveySubmissionDetailMapper surveySubmissionDetailMapper;

    @Override
    public void submitSurvey(SurveySubmissionDTO surveySubmissionDTO) {

        log.info("Inside saveSurvey");

        var submission = SurveySubmission.builder()
                .surveyId(surveySubmissionDTO.getSurveyId())
                .surveyName(surveySubmissionDTO.getSurveyName())
                .submittedOn(LocalDateTime.now())
                .submittedBy(surveySubmissionDTO.getSubmittedBy())
                .build();
        var detailList = new ArrayList<SurveySubmissionDetail>();
        for(var detailDto : surveySubmissionDTO.getSubmissionDetail()) {
            var detail = surveySubmissionDetailMapper
                    .convertSurveySubmissionDetailDTOToSurveySubmissionDetail(detailDto);
            detail.getSurveySubmissionAnswerList().forEach(ans->ans.setSurveySubmissionDetail(detail));
            detail.setSurveySubmission(submission);
            detailList.add(detail);
        }
        submission.setSurveySubmissionDetailList(detailList);

        log.debug("Invoking surveySubmissionRepository.save()");
        var survey = surveySubmissionRepository.save(submission);
        log.info("Saved Survey response");

    }
}
