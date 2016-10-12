package br.com.mario.abaco.model.sisp2_2;

import br.com.mario.abaco.model.Projeto;

public enum TipoContagemSISP {
	
	APLICACAO("Aplicação",new Aplicacao()),
	DESENVOLVIMENTO("Desenvolvimento", null),
	MELHORIA("Melhoria", null),
	MIGRACAO("Migração", null),
	MANUTENCAO_CORRETIVA("Manutenção Corretiva", null);
	
	private String descricao;
	private Projeto projeto;
	
	private TipoContagemSISP(String descricao, Projeto projeto){
		this.descricao = descricao;
		this.projeto = projeto;
	}

	public String getDescricao() {
		return descricao;
	}

	public Projeto getProjeto() {
		return projeto;
	}
	
	
}
