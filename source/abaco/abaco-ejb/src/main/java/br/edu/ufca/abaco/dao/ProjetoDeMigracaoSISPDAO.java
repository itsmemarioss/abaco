package br.edu.ufca.abaco.dao;

import br.edu.ufca.abaco.core.sisp.ProjetoDeMigracaoSISP;

import javax.persistence.EntityManager;

public class ProjetoDeMigracaoSISPDAO extends DAOGenerico<ProjetoDeMigracaoSISP, Long> {

	public ProjetoDeMigracaoSISPDAO(EntityManager entityManager) {
		super(ProjetoDeMigracaoSISP.class, entityManager);
	}

}
