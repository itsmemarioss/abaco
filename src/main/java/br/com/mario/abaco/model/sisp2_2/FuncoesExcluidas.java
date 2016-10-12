package br.com.mario.abaco.model.sisp2_2;

import br.com.mario.abaco.model.Contagem;

public class FuncoesExcluidas extends Contagem {
	
	public FuncoesExcluidas() {
		super(FuncoesExcluidas.class.getName());
	}

	@Override
	public double total() {
		double total = 0;
		total += super.total() * 0.3;
		return total;
	}
	
}
