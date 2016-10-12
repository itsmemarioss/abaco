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
import br.com.mario.abaco.model.TipoFuncaoDado;
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
		
		return mv;
	}
	
	@RequestMapping("/funcaoDeDado")
	public ModelAndView addFuncaoDeDado(FuncaoDeDado funcao){
		ModelAndView mv = new ModelAndView("contagem-aplicacao");

		aplicacao.addFuncaoDeDado(funcao);
		mv.addObject("analise", analise);
		mv.addObject("arquivos", aplicacao.getArquivos());
		mv.addObject("funcaoDeDado", new FuncaoDeDado());
		
		return mv;
	}
	
	@ModelAttribute
	public List<TipoFuncaoDado> tipoFuncaoDado(){
		return Arrays.asList(TipoFuncaoDado.values());
	}
	
}
