package br.com.cactusteam.abaco.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.*;

/**
 * Classe que representa o agrupamento de funções medidas,como pontos de função incluídos, excluídos ou alterados.
 * Cada {@link Projeto} define uma ou mais contagens.
 * 
 * @author mario
 *
 */
@Entity
public class Contagem implements BaseEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="contagem_id")
	private Set<FuncaoDeDado> funcoesDeDado;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="contagem_id")
	private Set<FuncaoDeTransacao> funcoesDeTransacao;
	
	public Contagem() {
		funcoesDeDado = new HashSet<>();
		funcoesDeTransacao = new HashSet<>();
	}

	/**
	 * retorna o valor de todas as funções sem diferenciar {@link Situacao}
	 * @return total
	 * @see Situacao
	 */
	public double totalizar(){
		Stream<Funcao> funcoes = Stream.concat(funcoesDeDado.stream(), funcoesDeTransacao.stream());
		return funcoes.mapToDouble(Funcao::getContribuicao).sum();
	}

	/**
	 * retorna o valor das funcões por situação
	 * @param situacao
	 * @return
	 */
	public double totalizarPorSituacao(Situacao situacao){
		Stream<Funcao> funcoes = Stream.concat(funcoesDeDado.stream(), funcoesDeTransacao.stream());
		return funcoes.filter(f -> f.getSituacao().equals(situacao))
				.mapToDouble(Funcao::getContribuicao).sum();
	}

	@Override
	public Long getId() {
		return id;
	}

	/**
	 * @return retorna um Set não-modificável das funções de dado
	 */
	public Set<FuncaoDeDado> getFuncoesDeDado() {
		return Collections.unmodifiableSet(funcoesDeDado);
	}
	
	public boolean addFuncaoDeDado(FuncaoDeDado funcao){
		return funcoesDeDado.add(funcao);
	}

	/**
	 * @return retorna um Set não-modificável das funções de transação
	 */
	public Set<FuncaoDeTransacao> getFuncoesDeTransacao() {
		return Collections.unmodifiableSet(funcoesDeTransacao);
	}

	public boolean addFuncaoDeTransacao(FuncaoDeTransacao funcao){
		return funcoesDeTransacao.add(funcao);
	}

	public int totalFuncoesDeDado() {
		return funcoesDeDado.size();
	}

	public int totalFuncoesDeTransacao() {
		return funcoesDeTransacao.size();
	}

	public boolean removeFuncaoDeDado(FuncaoDeDado funcao) {
		return funcoesDeDado.remove(funcao);
	}

	public boolean removeFuncaoDeTransacao(FuncaoDeTransacao funcao) {
		return funcoesDeTransacao.remove(funcao);
	}
	
	
}
