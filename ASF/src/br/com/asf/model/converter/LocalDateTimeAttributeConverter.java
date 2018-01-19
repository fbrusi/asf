package br.com.asf.model.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime date) {
		
		if(date == null) {
			return null;
		}
		
		return Timestamp.valueOf(date);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp date) {
		
		if(date == null) {
			return null;
		}
		
		return date.toLocalDateTime();
	}
}
