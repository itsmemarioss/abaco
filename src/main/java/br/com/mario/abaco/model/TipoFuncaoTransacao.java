package br.com.mario.abaco.model;

public enum TipoFuncaoTransacao {
	
	CE("Consulta Externa"),
	EE("Entrada Externa"),
	SE("Saída Externa");
	
	private String descricao;

	private TipoFuncaoTransacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}

}
