package com.marketlogic.survey.persistence.repo.submission;

import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import com.marketlogic.survey.persistence.entity.submission.SurveySubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveySubmissionRepository extends JpaRepository<SurveySubmission, Long> {
	
    Optional<SurveySubmission> findById(long id);
        
}