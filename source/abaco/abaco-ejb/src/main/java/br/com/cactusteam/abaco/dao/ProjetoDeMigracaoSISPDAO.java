package br.com.cactusteam.abaco.dao;

import br.com.cactusteam.abaco.core.sisp.ProjetoDeMigracaoSISP;

import javax.persistence.EntityManager;

public class ProjetoDeMigracaoSISPDAO extends DAOGenerico<ProjetoDeMigracaoSISP, Long> {

	public ProjetoDeMigracaoSISPDAO(EntityManager entityManager) {
		super(ProjetoDeMigracaoSISP.class, entityManager);
	}

}
