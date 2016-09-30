package br.com.mario.abaco.model;

import java.util.List;

public class Contagem {
	
	private String descricao;
	private String proposito;
	private TipoContagem tipo;
	private String fronteira;
	private String escopo;
	
	private List<FuncaoDeDado> funcoesDeDados;
	private List<FuncaoDeTransacao> funcoesDeTransacao;
	
}
