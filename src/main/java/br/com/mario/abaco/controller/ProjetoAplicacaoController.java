package br.com.mario.abaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeAplicacao;

@Controller
@RequestMapping("/contagem/aplicacao")
public class ProjetoAplicacaoController extends ProjetoController<ProjetoDeAplicacao>{
	
	private static final String NOME = "aplicacao";

	@Override
	@RequestMapping
	public ModelAndView pagina(@ModelAttribute("analise") Analise analise){
		ModelAndView mv = new ModelAndView(pagina());
		
		this.analise = analise;
		this.projeto = (ProjetoDeAplicacao) analise.getProjeto();
		
		addObjects(mv);
		
		return mv;
	}

	@Override
	void addObjects(ModelAndView mv) {
		super.addObjects(mv);
		mv.addObject("arquivos", projeto.getArquivos());
		mv.addObject("transacoes", projeto.getTransacoes());
	}
	
	@RequestMapping("/voltar")
	public ModelAndView voltar(){
		return null;
	}
	
	@Override
	public String getControllerName() {
		return NOME;
	}

	@Override
	public String ajuda() {
		return "Contagem de solução desenvolvida e em uso, a fim de identificar a quantidade de pontos de função instalados";
	}
	
}
