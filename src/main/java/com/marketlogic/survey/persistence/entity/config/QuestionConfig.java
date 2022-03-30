package com.marketlogic.survey.persistence.entity.config;

import com.marketlogic.survey.mapper.config.JpaConverterJson;
import com.marketlogic.survey.persistence.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper=false) 
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionConfig extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int questionOrder;

	private String question;

	private String questionDesc;

	@Convert(converter = JpaConverterJson.class)
	@Column(name = "answer")
	private AnswerConfigList answer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "survey_id", nullable = false)
	private SurveyConfig survey;

}
