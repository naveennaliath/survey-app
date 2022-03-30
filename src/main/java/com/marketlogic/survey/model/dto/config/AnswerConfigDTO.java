package com.marketlogic.survey.model.dto.config;

import com.marketlogic.survey.model.dto.BaseDTO;
import lombok.*;

/**
 * DTO for Answer
 *
 * @author Naveen John
 */
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerConfigDTO extends BaseDTO {

	private String answer;

}