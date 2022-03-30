package com.marketlogic.survey.persistence.repo.config;

import java.util.Optional;

import com.marketlogic.survey.persistence.entity.config.SurveyConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyConfigRepository extends JpaRepository<SurveyConfig, Long> {
	
    Optional<SurveyConfig> findById(long id);
        
}