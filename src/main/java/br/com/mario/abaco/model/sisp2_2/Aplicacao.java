package br.com.mario.abaco.model.sisp2_2;

import br.com.mario.abaco.model.Contagem;
import br.com.mario.abaco.model.Projeto;

public class Aplicacao implements Projeto {

	private Contagem pfIncluidos;
	
	@Override
	public double total() {
		return pfIncluidos.total();
	}

}
