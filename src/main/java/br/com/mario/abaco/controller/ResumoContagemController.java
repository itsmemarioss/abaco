package br.com.mario.abaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Analise;

@Controller
@RequestMapping("/contagem/resumo")
public class ResumoContagemController{
	
	private Analise analise;
	private String urlAnterior;
	
	@GetMapping
	public ModelAndView resumo(@ModelAttribute Analise analise, @ModelAttribute String urlAnterior){
		ModelAndView mv = new ModelAndView("resumo-contagem");
		
		this.analise = analise;
		this.urlAnterior = urlAnterior;
		System.out.println(">>> "+urlAnterior);
		
		mv.addObject("analise", analise);
		
		return mv;
	}
	
	@RequestMapping("/next")
	public ModelAndView next(RedirectAttributes attr){
		ModelAndView mv = new ModelAndView("redirect:/contagem/finalizar");
		attr.addFlashAttribute("analise", analise);
		return mv;
	}
	
	@RequestMapping("/back")
	public ModelAndView back(RedirectAttributes attr){
		ModelAndView mv = new ModelAndView("redirect:"+urlAnterior);
		attr.addFlashAttribute("analise", analise);
		
		return mv;
	}

}
