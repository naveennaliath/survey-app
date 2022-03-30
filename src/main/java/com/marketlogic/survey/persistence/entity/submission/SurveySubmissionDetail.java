package com.marketlogic.survey.persistence.entity.submission;

import com.marketlogic.survey.persistence.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false) 
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveySubmissionDetail extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String question;

	private String questionDesc;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "survey_submission_id", nullable = false)
	private SurveySubmission surveySubmission;

	@OneToMany(mappedBy = "surveySubmissionDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SurveySubmissionAnswer> surveySubmissionAnswerList = new ArrayList<>();

}
