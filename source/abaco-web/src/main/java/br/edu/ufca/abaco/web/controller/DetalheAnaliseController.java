package br.edu.ufca.abaco.web.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.edu.ufca.abaco.core.DetalheAnalise;
import br.edu.ufca.abaco.web.service.DetalheAnaliseService;

@Controller
public class DetalheAnaliseController {
	
	@Inject
	private DetalheAnaliseService service;
	
	public void salvar(DetalheAnalise detalhe){
		service.salvar(detalhe);
	}
	
	public void formulario(){
		System.out.println("acessando método formulário");
	}
	
	public List<DetalheAnalise> listar(){
		return service.listar();
	}

}
