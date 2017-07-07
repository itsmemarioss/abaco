package br.edu.ufca.abaco.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ufca.abaco.core.sisp.ProjetoDeMigracaoSISP;
import br.edu.ufca.abaco.dao.ProjetoDeMigracaoSISPDAO;

@Stateless
public class ProjetoDeMigracaoSISPService implements Serializable{
	
	@Inject
	private ProjetoDeMigracaoSISPDAO dao;
	
	public void salvar(ProjetoDeMigracaoSISP projeto){
		dao.salvar(projeto);
	}

}
