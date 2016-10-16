package br.com.mario.abaco.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Contagem {
	
	private String descricao;
	private double fatorDeImpacto = 1;
	
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
		return result * fatorDeImpacto;
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

	public double getFatorDeImpacto() {
		return fatorDeImpacto;
	}

	public void setFatorDeImpacto(double fatorDeImpacto) {
		this.fatorDeImpacto = fatorDeImpacto;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setArquivos(List<FuncaoDeDado> arquivos) {
		this.arquivos = arquivos;
	}

	public void setFuncoesDeTransacao(List<FuncaoDeTransacao> funcoesDeTransacao) {
		this.funcoesDeTransacao = funcoesDeTransacao;
	}
	
	
}
