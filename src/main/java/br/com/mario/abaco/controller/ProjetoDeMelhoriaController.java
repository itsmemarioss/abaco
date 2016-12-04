package br.com.mario.abaco.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.Contagem;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeMelhoria;

@Controller
@Scope("session")
@RequestMapping("/contagem/melhoria")
public class ProjetoDeMelhoriaController extends ProjetoController<ProjetoDeMelhoria>{

	private static final String NOME = "melhoria";
	
	@Override
	public String pagina() {
		return "contagem-melhoria";
	}

	@Override
	@GetMapping
	public ModelAndView pagina(@ModelAttribute("analise") Analise analise) {
		ModelAndView mv = new ModelAndView(pagina());
		
		this.analise = analise;
		this.projeto = (ProjetoDeMelhoria) analise.getProjeto();
		
		addObjects(mv);
		
		return mv;
	}
	
	@Override
	void addObjects(ModelAndView mv) {
		super.addObjects(mv);
		mv.addObject("melhoria", projeto.getContagens().get(1));
	}

	@PostMapping("fi")
	public ModelAndView mudaFatorDeImpactoAlterado(double fatorDeImpacto){
		ModelAndView mv = new ModelAndView(pagina());
		
		this.projeto.getContagens().get(1).setFatorDeImpacto(fatorDeImpacto);
		addObjects(mv);
		
		return mv;
	}
	
	@Override
	public String getControllerName() {
		return NOME;
	}
	
	@ModelAttribute(name="fatorDeImpactoList")
	public List<ProjetoDeMelhoria.FatorDeImpacto> fatorDeImpacto(){
		return Arrays.asList(ProjetoDeMelhoria.FatorDeImpacto.values());
	}
	
	@Override
	public String ajuda() {
		return "O Projeto de Melhoria (enhancement), também denominado de projeto de melhoria"
				+ " funcional ou manutenção evolutiva, está associado às mudanças em requisitos funcionais"
				+ " da aplicação, ou seja, à inclusão de novas funcionalidades, alteração ou exclusão de "
				+ " funcionalidades em aplicações implantadas.";
	}	
}
