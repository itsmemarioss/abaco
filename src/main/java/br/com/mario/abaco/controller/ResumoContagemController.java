package br.com.mario.abaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;

@Controller
@RequestMapping("/contagem")
public class ResumoContagemController {
	
	@RequestMapping("/resumo")
	public ModelAndView resumo(@ModelAttribute Analise analise){
		ModelAndView mv = new ModelAndView("resumo-contagem");
		mv.addObject("analise", analise);
		return mv;
	}

}
