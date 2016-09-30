package br.com.mario.abaco.model;

public abstract class FuncaoDeTransacao extends Funcao {
	
	private int arquivosReferenciados;

	public FuncaoDeTransacao(int arquivosReferenciados, int tipoDeDados) {
		super();
		this.arquivosReferenciados = arquivosReferenciados;
		this.tipoDeDados = tipoDeDados;
	}

	public int getArquivosReferenciados() {
		return arquivosReferenciados;
	}
	
	

}
