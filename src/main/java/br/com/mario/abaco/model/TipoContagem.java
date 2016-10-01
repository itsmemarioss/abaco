package br.com.mario.abaco.model;

public enum TipoContagem {
	APLICACAO("Aplicação"),
	DESENVOLVIMENTO("Desenvolvimento"),
	MELHORIA("Melhoria"),
	MIGRACAO("Migração"),
	MANUTENCAO_CORRETIVA("Manutenção Corretiva");
	
	private String descricao;
	
	private TipoContagem(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
