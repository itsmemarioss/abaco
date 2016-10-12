package br.com.mario.abaco.model;

public enum TipoFuncaoDado {
	ALI("Arquivo Lógico Interno"), 
	AIE("Arquivo de Interface Externa");
	
	private String descricao;
	
	private TipoFuncaoDado(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
