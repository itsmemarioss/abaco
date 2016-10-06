package br.com.mario.abaco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.mario.abaco.controller.converter.SistemaConverter;
import br.com.mario.abaco.service.SistemaService;

@SpringBootApplication
public class AbacoApplication extends WebMvcConfigurerAdapter {
	
	@Bean
	public SistemaService sistemaService(){
		return new SistemaService();
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new SistemaConverter(sistemaService()));
	}

	public static void main(String[] args) {
		SpringApplication.run(AbacoApplication.class, args);
	}
	
}
