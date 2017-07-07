package br.edu.ufca.abaco.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ufca.abaco.core.DetalheAnalise;
import br.edu.ufca.abaco.core.sisp.ProjetoDeMigracaoSISP;
import br.edu.ufca.abaco.service.ProjetoDeMigracaoSISPService;

@Named
@ViewScoped
public class ProjetoDeMigracaoSISPBean implements Serializable{

	@Inject
	private ProjetoDeMigracaoSISPService service;
	
	private DetalheAnalise detalhe;
	private ProjetoDeMigracaoSISP projetoDeMigracaoSISP;
	
	@PostConstruct
	public void setup(){
		detalhe = new DetalheAnalise();
		projetoDeMigracaoSISP = new ProjetoDeMigracaoSISP(detalhe);
	}

	public DetalheAnalise getDetalhe() {
		return detalhe;
	}

	public ProjetoDeMigracaoSISP getProjetoDeMigracaoSISP() {
		return projetoDeMigracaoSISP;
	}
	
	
}
