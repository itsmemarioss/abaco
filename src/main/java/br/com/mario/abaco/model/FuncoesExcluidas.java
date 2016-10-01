package br.com.mario.abaco.model;

public class FuncoesExcluidas extends Contagem {
	
	private Contagem contagem;
	
	public FuncoesExcluidas(Contagem pfIncluido, String descricao) {
		super(descricao);
		this.contagem = pfIncluido;
	}

	@Override
	public double total() {
		double total = contagem.total();
		total += super.total() * 0.3;
		return total;
	}
	
}
