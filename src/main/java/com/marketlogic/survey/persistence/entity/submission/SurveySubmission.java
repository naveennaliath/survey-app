package com.marketlogic.survey.persistence.entity.submission;

import com.marketlogic.survey.persistence.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false) 
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveySubmission extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long surveyId;

	private String surveyName;

	private LocalDateTime submittedOn;

	private String submittedBy;

	@OneToMany(mappedBy = "surveySubmission", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SurveySubmissionDetail> surveySubmissionDetailList = new ArrayList<>();

}
