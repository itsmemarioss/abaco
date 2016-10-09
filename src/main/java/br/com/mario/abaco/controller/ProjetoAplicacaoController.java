package br.com.mario.abaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;

@Controller
@RequestMapping("/contagem")
public class ProjetoAplicacaoController {

	@RequestMapping("/aplicacao")
	public ModelAndView pagina(@ModelAttribute("analise") Analise analise){
		ModelAndView mv = new ModelAndView("contagem-aplicacao");
		mv.addObject("analise", analise);
		return mv;
	}
}
