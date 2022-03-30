package com.marketlogic.survey.persistence.entity.config;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerConfig {

	private long id;

	private long questionId;

	private String answer;

}
