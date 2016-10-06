package br.com.mario.abaco.controller.converter;

import org.springframework.core.convert.converter.Converter;

import br.com.mario.abaco.model.Sistema;
import br.com.mario.abaco.service.SistemaService;

public class SistemaConverter implements Converter<String, Sistema>{
	
	private SistemaService service;
	
	public SistemaConverter(SistemaService service) {
		this.service = service;
	}	
	
	@Override
	public Sistema convert(String nome) {
		System.out.println(nome);
		Sistema s = service.findByNome(nome); 
		return s;
	}

}
