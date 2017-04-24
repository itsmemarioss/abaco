package br.edu.ufca.abaco.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Classe que representa o agrupamento de funções medidas.
 * Como pontos de função incluídos, alterados.
 * Cada {@link Projeto} define uma ou mais contagens.
 * 
 * @author mario
 *
 */
@Entity
public class Contagem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name="contagem_id")
	private List<FuncaoDeDado> funcoesDeDado;
	
	@OneToMany
	@JoinColumn(name="contagem_id")
	private List<FuncaoDeTransacao> funcoesDeTransacao;
	
	public Contagem() {
		super();
		funcoesDeDado = new ArrayList<>();
		funcoesDeTransacao = new ArrayList<>();
	}

	public double total(){
		int result = 0;
		Stream<Funcao> funcoes = Stream.concat(funcoesDeDado.stream(), funcoesDeTransacao.stream());
		result = funcoes.mapToInt(Funcao::getContribuicao).sum();
		return result;
	}

	public Long getId() {
		return id;
	}

	public List<FuncaoDeDado> getFuncoesDeDado() {
		return funcoesDeDado;
	}

	public List<FuncaoDeTransacao> getFuncoesDeTransacao() {
		return funcoesDeTransacao;
	}
	
	
}
