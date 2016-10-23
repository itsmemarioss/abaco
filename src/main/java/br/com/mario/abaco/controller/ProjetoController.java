package br.com.mario.abaco.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.FuncaoDeDado;
import br.com.mario.abaco.model.FuncaoDeTransacao;
import br.com.mario.abaco.model.TipoFuncaoDado;
import br.com.mario.abaco.model.TipoFuncaoTransacao;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeAplicacao;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeMigracao;

public abstract class ProjetoController<T> {
	
	final String PAG_CONTAGEM = "contagem";
	
	Analise analise;
	T projeto;

	/**
	 * 
	 * @param analise deve ser anotada com @ModelAttribute("analise")
	 * @return
	 */
	public abstract ModelAndView pagina(Analise analise);
	
	void addObjects(ModelAndView mv) {
		mv.addObject("analise", analise);
		mv.addObject("funcaoDeDado", new FuncaoDeDado());
		mv.addObject("funcaoDeTransacao", new FuncaoDeTransacao());
		mv.addObject("projeto", projeto);
	}
	
	@ModelAttribute
	public List<TipoFuncaoDado> tipoFuncaoDado(){
		return Arrays.asList(TipoFuncaoDado.values());
	}
	
	@ModelAttribute
	public List<TipoFuncaoTransacao> tipoFuncaoTransacao(){
		return Arrays.asList(TipoFuncaoTransacao.values());
	}

}
