package br.com.mario.abaco.model;

import java.util.List;
import java.util.stream.Stream;

public class Contagem {
	
	private String descricao;
	
	public Contagem(String descricao) {
		super();
		this.descricao = descricao;
	}

	private List<FuncaoDeDado> arquivos;
	private List<FuncaoDeTransacao> funcoesDeTransacao;
	
	public double total(){
		int result = 0;
		Stream<Funcao> funcoes = Stream.concat(arquivos.stream(), funcoesDeTransacao.stream());
		result = funcoes.mapToInt(Funcao::getContribuicao).sum();
		return result;
	}
}
