package br.com.mario.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.repository.AnaliseRepository;

@Controller
@RequestMapping("/contagem/finalizar")
public class FinalizaContagemController {
	
	@Autowired
	private AnaliseRepository repo;

	@GetMapping
	public ModelAndView resumo(@ModelAttribute Analise analise, RedirectAttributes attr){
		ModelAndView mv = new ModelAndView("redirect:/");
		
		repo.save(analise);//salvar rascunho
		
		mv.addObject("analise", analise);
		attr.addFlashAttribute("mensagem", "Análise salva com sucesso");
		
		return mv;
	}

}
