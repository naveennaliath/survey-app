package com.marketlogic.survey.service.impl.report;

import com.marketlogic.survey.model.dto.report.SurveyDistributionAnswerDTO;
import com.marketlogic.survey.model.dto.report.SurveyDistributionDTO;
import com.marketlogic.survey.model.dto.report.SurveyDistributionQuestionDTO;
import com.marketlogic.survey.model.projection.report.SurveyDistributionProjection;
import com.marketlogic.survey.persistence.repo.report.SurveyReportRepository;
import com.marketlogic.survey.service.def.report.SurveyReportService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Service Implementation of {@link SurveyReportService}
 *
 * @author Naveen John
 */
@Service
@Slf4j
@NoArgsConstructor
public class SurveyReportServiceImpl implements SurveyReportService {

    @Autowired
    private SurveyReportRepository surveyReportRepository;

    @Override
    public SurveyDistributionDTO getSurveyResponseDistribution(long surveyId) {
        var surveyProjList = surveyReportRepository.getSurveyResponseDistribution(surveyId);
        String surveyName = surveyProjList.stream().findFirst().map(SurveyDistributionProjection::getSurveyName).get();
        var qtnList = surveyProjList.stream()
                .collect(Collectors.groupingBy(SurveyDistributionProjection::getQuestion));

        var qtnDtoList = new ArrayList<SurveyDistributionQuestionDTO>();


        for(var qtnEntry : qtnList.entrySet()) {
            var qtnDto = SurveyDistributionQuestionDTO.builder().question(qtnEntry.getKey()).build();
            var ansDtoList = new ArrayList<SurveyDistributionAnswerDTO>();

            qtnEntry.getValue().forEach(proj-> {
                ansDtoList.add(SurveyDistributionAnswerDTO.builder()
                    .answer(proj.getAnswer())
                            .relativeDistribution(proj.getPercentage())
                            .build());
            });
            qtnDto.setAnswerDetail(ansDtoList);
            qtnDtoList.add(qtnDto);
        }


        var distributionDTO = SurveyDistributionDTO.builder()
                .surveyId(surveyId).surveyName(surveyName).distributionDetail(qtnDtoList).build();
        return distributionDTO;
    }
}
