package br.com.mario.abaco.repository;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        Date date = localDate == null ? null : Date.valueOf(localDate);
        return date;
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        LocalDate localDate = date == null ? null : date.toLocalDate();
        return localDate;
    }
}