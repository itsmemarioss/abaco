package br.com.mario.abaco.model.sisp2_2;

import br.com.mario.abaco.model.Projeto;

public enum TipoContagemSISP {
	
	APLICACAO("Aplicação",new Aplicacao()),
	DESENVOLVIMENTO("Desenvolvimento", new Desenvolvimento()),
	MELHORIA("Melhoria", new Melhoria()),
	MIGRACAO("Migração",new ProjetoDeMigracao()),
	MANUTENCAO_CORRETIVA("Manutenção Corretiva",new ProjetoDeManutencaoCorretiva());
	
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
