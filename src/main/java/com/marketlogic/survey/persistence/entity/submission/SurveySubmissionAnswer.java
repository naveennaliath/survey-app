package com.marketlogic.survey.persistence.entity.submission;

import com.marketlogic.survey.persistence.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper=false) 
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveySubmissionAnswer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String answer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "survey_submission_detail_id", nullable = false)
	private SurveySubmissionDetail surveySubmissionDetail;

}
