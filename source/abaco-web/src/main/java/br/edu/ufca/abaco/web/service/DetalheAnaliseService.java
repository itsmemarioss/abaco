package br.edu.ufca.abaco.web.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.edu.ufca.abaco.core.DetalheAnalise;
import br.edu.ufca.abaco.web.dao.DetalheAnaliseDAO;

public class DetalheAnaliseService {
	
	@Inject
	private DetalheAnaliseDAO dao;

	@Transactional
	public void salvar(DetalheAnalise detalhe) {
		dao.salvar(detalhe);
	}

	public List<DetalheAnalise> listar() {
		return dao.listar();
	}
	
}
