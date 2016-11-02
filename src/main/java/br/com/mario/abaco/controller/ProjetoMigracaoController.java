package br.com.mario.abaco.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeMigracao;

@Controller
@Scope("session")
@RequestMapping("/contagem/migracao")
public class ProjetoMigracaoController extends ProjetoController<ProjetoDeMigracao>{
	
	private static final String NOME = "migracao";

	@Override
	@GetMapping
	public ModelAndView pagina(@ModelAttribute("analise") Analise analise){
		ModelAndView mv = new ModelAndView(pagina());
		
		this.analise = analise;
		this.projeto = (ProjetoDeMigracao) analise.getProjeto();
		
		addObjects(mv);
		
		return mv;
	}

	@Override
	public String getControllerName() {
		return NOME;
	}
	
}
