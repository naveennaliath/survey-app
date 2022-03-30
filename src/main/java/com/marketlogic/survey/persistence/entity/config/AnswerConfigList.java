package com.marketlogic.survey.persistence.entity.config;

import com.marketlogic.survey.model.dto.config.AnswerConfigDTO;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerConfigList {

	private List<AnswerConfigDTO> answerList;

}
