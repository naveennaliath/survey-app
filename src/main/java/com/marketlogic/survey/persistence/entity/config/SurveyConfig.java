package com.marketlogic.survey.persistence.entity.config;

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
public class SurveyConfig extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String surveyName;

	private String surveyDescription;

	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<QuestionConfig> questionList = new ArrayList<>();


}