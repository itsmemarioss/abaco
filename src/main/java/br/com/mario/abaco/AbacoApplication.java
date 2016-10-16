package br.com.mario.abaco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.mario.abaco.controller.converter.SistemaConverter;
import br.com.mario.abaco.service.SistemaService;
import br.com.mario.abaco.storage.StorageProperties;
import br.com.mario.abaco.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AbacoApplication extends WebMvcConfigurerAdapter {
	
	@Bean
	public SistemaService sistemaService(){
		return new SistemaService();
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new SistemaConverter(sistemaService()));
	}

	public static void main(String[] args) {
		SpringApplication.run(AbacoApplication.class, args);
	}
	
}
