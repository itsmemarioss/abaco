package br.com.mario.abaco.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.FuncaoDeDado;
import br.com.mario.abaco.model.FuncaoDeTransacao;
import br.com.mario.abaco.model.Projeto;
import br.com.mario.abaco.model.TipoFuncaoDado;
import br.com.mario.abaco.model.TipoFuncaoTransacao;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeAplicacao;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeMigracao;

public abstract class ProjetoController<T extends Projeto> {
	
	Analise analise;
	T projeto;

	/**
	 * 
	 * @param analise deve ser anotada com @ModelAttribute("analise")
	 * @return
	 */
	public abstract ModelAndView pagina(Analise analise);
	
	public String redirectPagina(){
		return "redirect:/contagem/";
	}
	
	public String pagina(){
		return "contagem";
	}
	
	public abstract String getControllerName();
	
	void addObjects(ModelAndView mv) {
		mv.addObject("analise", analise);
		mv.addObject("funcaoDeDado", new FuncaoDeDado());
		mv.addObject("funcaoDeTransacao", new FuncaoDeTransacao());
		mv.addObject("projeto", projeto);
		mv.addObject("controller", getControllerName());
	}

	@ModelAttribute
	public List<TipoFuncaoDado> tipoFuncaoDado(){
		return Arrays.asList(TipoFuncaoDado.values());
	}
	
	@ModelAttribute
	public List<TipoFuncaoTransacao> tipoFuncaoTransacao(){
		return Arrays.asList(TipoFuncaoTransacao.values());
	}
	
	@PostMapping("/funcaoDeDado/{tab}")
	public ModelAndView addFuncaoDeDado(@PathVariable int tab, FuncaoDeDado funcao, RedirectAttributes att){
		ModelAndView mv = new ModelAndView(redirectPagina()+getControllerName());

		projeto.addFuncaoDeDado(tab, funcao);
		
		att.addFlashAttribute("analise", analise);
		att.addFlashAttribute("funcaoDeDado", new FuncaoDeDado());
		att.addFlashAttribute("funcaoDeTransacao", new FuncaoDeTransacao());
		att.addFlashAttribute("projeto", projeto);
		att.addFlashAttribute("controller", getControllerName());
		
		return mv;
	}
	
	@PostMapping("/funcaoDeTransacao/{tab}")
	public ModelAndView addFuncaoDeTransacao(@PathVariable int tab, FuncaoDeTransacao funcao, RedirectAttributes att){
		ModelAndView mv = new ModelAndView(redirectPagina()+getControllerName());
		
		projeto.addFuncaoDeTransacao(tab, funcao);
		
		att.addFlashAttribute("analise", analise);
		att.addFlashAttribute("funcaoDeDado", new FuncaoDeDado());
		att.addFlashAttribute("funcaoDeTransacao", new FuncaoDeTransacao());
		att.addFlashAttribute("projeto", projeto);
		att.addFlashAttribute("controller", getControllerName());
		
		return mv;
	}
	
	@RequestMapping("/next")
	public ModelAndView next(RedirectAttributes attr){
		ModelAndView mv = new ModelAndView("redirect:/contagem/resumo");
		attr.addFlashAttribute("analise", analise);
		return mv;
	}

}
