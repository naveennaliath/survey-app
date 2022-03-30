package com.marketlogic.survey.persistence.repo.config;

import com.marketlogic.survey.model.projection.config.QuestionProjection;
import com.marketlogic.survey.persistence.entity.config.QuestionConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionConfigRepository extends JpaRepository<QuestionConfig, Long> {
	
    Optional<QuestionConfig> findById(long id);

    @Query("SELECT q FROM QuestionConfig q WHERE q.survey.id=(:surveyId)")
    public List<QuestionProjection> getQuestionOnlyBySurveyId(long surveyId);

    @Query("SELECT q FROM QuestionConfig q WHERE q.survey.id=(:surveyId)")
    public List<QuestionConfig> getQuestionBySurveyId(long surveyId);
        
}