package br.edu.ufca.abaco.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ufca.abaco.core.sisp.ProjetoDeMigracaoSISP;
import br.edu.ufca.abaco.dao.ProjetoDeMigracaoSISPDAO;

@Stateless
public class ProjetoDeMigracaoSISPService implements Serializable{

	@PersistenceContext(name = "abaco")
	private EntityManager entityManager;

	private ProjetoDeMigracaoSISPDAO dao;
	
	public void salvarOuAtualizar(ProjetoDeMigracaoSISP projeto){
		if (projeto.getId()==null || projeto.getId() == 0)
			dao.salvar(projeto);
		else
			dao.atualizar(projeto);
	}

	@PostConstruct
	public void setup(){
		dao = new ProjetoDeMigracaoSISPDAO(entityManager);
	}

}
