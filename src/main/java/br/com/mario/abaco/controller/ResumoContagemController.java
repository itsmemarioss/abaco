package br.com.mario.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.repository.AnaliseRepository;

@Controller
@Scope("session")
@RequestMapping("/contagem/resumo")
public class ResumoContagemController{
	
	@Autowired
	private AnaliseRepository repo;
	
	private Analise analise;
	private String urlAnterior;
	
	@GetMapping
	public ModelAndView resumo(@ModelAttribute Analise analise, @ModelAttribute String urlAnterior){
		ModelAndView mv = new ModelAndView("resumo-contagem");
		
		this.analise = analise;
		this.urlAnterior = urlAnterior;
		System.out.println(">>> "+urlAnterior);
		
		repo.save(analise);//salvar rascunho
		
		mv.addObject("analise", analise);
		
		return mv;
	}
	
	@PostMapping("/finalizar/{id}")
	public ModelAndView finalizar(RedirectAttributes attr){
		ModelAndView mv = new ModelAndView("index");
		
		repo.save(analise);
		
		attr.addFlashAttribute("mensagem", "Nova Análise salva com sucesso!");
		return mv;
	}
	
	@RequestMapping("/back")
	public ModelAndView back(RedirectAttributes attr){
		ModelAndView mv = new ModelAndView("redirect:"+urlAnterior);
		attr.addFlashAttribute("analise", analise);
		
		return mv;
	}

}
