package br.com.mario.abaco.controller.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import br.com.mario.abaco.model.Sistema;
import br.com.mario.abaco.service.SistemaService;

public class SistemaFormatter implements Formatter<Sistema>{
	
	private SistemaService service;
	
	public SistemaFormatter(SistemaService service) {
		this.service = service;
	}

	@Override
	public String print(Sistema object, Locale locale) {
		return (object != null ? object.getId().toString() : "");
	}

	@Override
	public Sistema parse(String text, Locale locale) throws ParseException {
		Long id = Long.valueOf(text);
        return service.findById(id);
	}	
	
}
