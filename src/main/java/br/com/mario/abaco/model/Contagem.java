package br.com.mario.abaco.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Contagem {
	
	private String descricao;
	
	public Contagem(String descricao) {
		super();
		this.descricao = descricao;
		arquivos = new ArrayList<>();
		funcoesDeTransacao = new ArrayList<>();
	}

	private List<FuncaoDeDado> arquivos;
	private List<FuncaoDeTransacao> funcoesDeTransacao;
	
	public double total(){
		int result = 0;
		Stream<Funcao> funcoes = Stream.concat(arquivos.stream(), funcoesDeTransacao.stream());
		result = funcoes.mapToInt(Funcao::getContribuicao).sum();
		return result;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public List<FuncaoDeDado> getArquivos() {
		return arquivos;
	}

	public List<FuncaoDeTransacao> getFuncoesDeTransacao() {
		return funcoesDeTransacao;
	}

	public void addFuncaoDeDado(FuncaoDeDado funcao){
		arquivos.add(funcao);
	}
	
	public void addFuncaoDeTransacao(FuncaoDeTransacao funcao){
		funcoesDeTransacao.add(funcao);
	}
}
