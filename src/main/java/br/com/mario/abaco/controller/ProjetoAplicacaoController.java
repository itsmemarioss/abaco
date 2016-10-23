package br.com.mario.abaco.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.FuncaoDeDado;
import br.com.mario.abaco.model.FuncaoDeTransacao;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeAplicacao;

@Controller
@Scope("session")
@RequestMapping("/contagem")
public class ProjetoAplicacaoController extends ProjetoController<ProjetoDeAplicacao>{
	
	@Override
	@RequestMapping("/aplicacao")
	public ModelAndView pagina(@ModelAttribute("analise") Analise analise){
		ModelAndView mv = new ModelAndView(PAG_CONTAGEM);
		
		this.analise = analise;
		this.projeto = (ProjetoDeAplicacao) analise.getProjeto();
		
		addObjects(mv);
		
		return mv;
	}
	
	@RequestMapping("/funcaoDeDado/{tab}")
	public ModelAndView addFuncaoDeDado(@PathVariable int tab, FuncaoDeDado funcao){
		ModelAndView mv = new ModelAndView(PAG_CONTAGEM);

		System.out.println(tab);
		projeto.addFuncaoDeDado(tab, funcao);
		addObjects(mv);
		
		return mv;
	}
	
	@Override
	void addObjects(ModelAndView mv) {
		super.addObjects(mv);
		mv.addObject("arquivos", projeto.getArquivos());
		mv.addObject("transacoes", projeto.getTransacoes());
	}

	@RequestMapping("/funcaoDeTransacao")
	public ModelAndView addFuncaoDeTransacao(FuncaoDeTransacao funcao){
		ModelAndView mv = new ModelAndView(PAG_CONTAGEM);

		projeto.addFuncaoDeTransacao(funcao);
		addObjects(mv);
		
		return mv;
	}
	
	@RequestMapping("/voltar")
	public ModelAndView voltar(){
		//TODO
		return null;
	}
	
	@RequestMapping("/next")
	public ModelAndView next(RedirectAttributes attr){
		ModelAndView mv = new ModelAndView("redirect:/contagem/resumo");
		attr.addFlashAttribute("analise", analise);
		attr.addFlashAttribute("urlAnterior", "/contagem/aplicacao");
		return mv;
	}
	
}
