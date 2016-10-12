package br.com.mario.abaco.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.Contagem;
import br.com.mario.abaco.model.FuncaoDeDado;
import br.com.mario.abaco.model.FuncaoDeTransacao;
import br.com.mario.abaco.model.TipoFuncaoDado;
import br.com.mario.abaco.model.TipoFuncaoTransacao;
import br.com.mario.abaco.model.sisp2_2.Aplicacao;

@Controller
@RequestMapping("/contagem")
public class ProjetoAplicacaoController {
	
	private Analise analise;
	private Aplicacao aplicacao;
	//TODO: criar sevirce

	@RequestMapping("/aplicacao")
	public ModelAndView pagina(@ModelAttribute("analise") Analise analise){
		ModelAndView mv = new ModelAndView("contagem-aplicacao");
		
		this.analise = analise;
		this.aplicacao = (Aplicacao) analise.getProjeto();
		
		mv.addObject("analise", analise);
		mv.addObject("funcaoDeDado", new FuncaoDeDado());
		mv.addObject("funcaoDeTransacao", new FuncaoDeTransacao());
		
		return mv;
	}
	
	@RequestMapping("/funcaoDeDado")
	public ModelAndView addFuncaoDeDado(FuncaoDeDado funcao){
		ModelAndView mv = new ModelAndView("contagem-aplicacao");

		aplicacao.addFuncaoDeDado(funcao);
		addObjects(mv);
		
		return mv;
	}
	
	private void addObjects(ModelAndView mv) {
		mv.addObject("analise", analise);
		
		mv.addObject("arquivos", aplicacao.getArquivos());
		mv.addObject("funcaoDeDado", new FuncaoDeDado());
		
		mv.addObject("transacoes", aplicacao.getTransacoes());
		mv.addObject("funcaoDeTransacao", new FuncaoDeTransacao());		
	}

	@RequestMapping("/funcaoDeTransacao")
	public ModelAndView addFuncaoDeTransacao(FuncaoDeTransacao funcao){
		ModelAndView mv = new ModelAndView("contagem-aplicacao");

		aplicacao.addFuncaoDeTransacao(funcao);
		addObjects(mv);
		
		return mv;
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
