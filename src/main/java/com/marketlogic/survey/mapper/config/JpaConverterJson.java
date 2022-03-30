package com.marketlogic.survey.mapper.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketlogic.survey.persistence.entity.config.AnswerConfigList;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Slf4j
@Converter(autoApply = true)
public class JpaConverterJson implements AttributeConverter<AnswerConfigList, String> {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(AnswerConfigList meta) {
		try {
			return objectMapper.writeValueAsString(meta);
		} catch (JsonProcessingException ex) {
			log.error(ex.getMessage(), ex);
			return null;
		}
	}

	@Override
	public AnswerConfigList convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, AnswerConfigList.class);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			return null;
		}
	}

}



