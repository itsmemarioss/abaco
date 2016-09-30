package br.com.mario.abaco.model;

public abstract class Funcao {
	
	private String descricao;
	int tipoDeDados;
	
	public abstract Complexidade getComplexidade();
	public abstract int getContribuicao();
	
	public String getDescricao() {
		return descricao;
	}
	public int getTipoDeDados() {
		return tipoDeDados;
	}
	
	

}
