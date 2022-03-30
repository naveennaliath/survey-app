package com.marketlogic.survey.persistence.repo.report;

import com.marketlogic.survey.model.projection.report.SurveyDistributionProjection;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Optional;

public interface SurveyReportRepository extends JpaRepository<SurveySubmission, Long> {

    @Query(value = "SELECT DISTINCT SUB.SURVEY_NAME as surveyName,QUESTION,ANSWER,\n" +
            "       COUNT(*) OVER (PARTITION BY SUB.ID,QUESTION) AS TOTAL,\n" +
            "       ROUND(CAST(COUNT(*) OVER (PARTITION BY QUESTION,ANSWER) AS FLOAT)* 100 /\n" +
            "       COUNT(*) OVER (PARTITION BY QUESTION),2) AS PERCENTAGE\n" +
            "FROM SURVEY_SUBMISSION SUB\n" +
            "JOIN SURVEY_SUBMISSION_DETAIL DTL\n" +
            "ON DTL.SURVEY_SUBMISSION_ID=SUB.ID\n" +
            "JOIN SURVEY_SUBMISSION_ANSWER ANS\n" +
            "ON ANS.SURVEY_SUBMISSION_DETAIL_ID=DTL.ID" +
            " WHERE SUB.SURVEY_ID =?1", nativeQuery = true)
    List<SurveyDistributionProjection> getSurveyResponseDistribution(long surveyId);
        
}