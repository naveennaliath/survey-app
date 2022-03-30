package com.marketlogic.survey.model.dto.config;

import com.marketlogic.survey.model.dto.BaseDTO;
import lombok.*;

import java.util.List;

/**
 * DTO for Question List
 *
 * @author Naveen John
 */
@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionConfigListDTO extends BaseDTO {

	/**Survey Id**/
	private long id;

	private List<QuestionConfigDTO> questionList;

}