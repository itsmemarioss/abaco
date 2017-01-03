package br.com.mario.abaco.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.sisp2_2.ProjetoDeDesenvolvimento;

@Controller
@Scope("session")
@RequestMapping("/contagem/desenvolvimento")
public class ProjetoDesenvolivmentoController extends ProjetoController<ProjetoDeDesenvolvimento> {

	private static final String NOME = "desenvolvimento";
	
	@Override
	@GetMapping
	public ModelAndView pagina(@ModelAttribute("analise") Analise analise) {
		ModelAndView mv = new ModelAndView(pagina());
		
		this.analise = analise;
		this.projeto = (ProjetoDeDesenvolvimento) analise.getProjeto();
		
		addObjects(mv);
		
		return mv;
	}

	@Override
	public String getControllerName() {
		return NOME;
	}

	@Override
	public String ajuda() {
		return "É o projeto para desenvolver e entregar a primeira versão de uma aplicação de "
				+ "software. Seu tamanho funcional é a medida das funcionalidades entregues ao usuário no "
				+ "final do projeto. Também considera-se as funcionalidades de conversão de dados.";
	}

}
