package br.com.mario.abaco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.repository.AnaliseRepository;

@Controller
public class IndexController {
	
	@Autowired
	private AnaliseRepository repo;

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@ModelAttribute
	public List<Analise> analises(){
		return repo.findAll();
	}
}
