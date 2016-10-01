package br.com.mario.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.repository.InstituicoesRepository;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {

	@Autowired
	private InstituicoesRepository repo;
	
	@GetMapping
	public ModelAndView pag(){
		ModelAndView mv = new ModelAndView("instituicao");
		return mv;
	}
	
}
