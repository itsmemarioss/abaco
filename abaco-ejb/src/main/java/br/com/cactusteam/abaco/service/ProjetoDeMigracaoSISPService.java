package br.com.cactusteam.abaco.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.cactusteam.abaco.core.sisp.ProjetoDeMigracaoSISP;
import br.com.cactusteam.abaco.dao.ProjetoDeMigracaoSISPDAO;

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

	public List<ProjetoDeMigracaoSISP> buscarTodos(){
		return dao.listar();
	}

	@PostConstruct
	public void setup(){
		dao = new ProjetoDeMigracaoSISPDAO(entityManager);
	}

}
