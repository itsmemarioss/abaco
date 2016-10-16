package br.com.mario.abaco.model.sisp2_2;

public enum TipoContagemSISP {
	
	APLICACAO("Aplicação"),
	DESENVOLVIMENTO("Desenvolvimento"),
	MELHORIA("Melhoria"),
	MIGRACAO("Migração");
	
	private String descricao;
	
	private TipoContagemSISP(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
