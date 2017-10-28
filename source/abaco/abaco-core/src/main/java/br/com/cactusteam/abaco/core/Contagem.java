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
	
	public double total(){
		double result = 0;
		Stream<Funcao> funcoes = Stream.concat(funcoesDeDado.stream(), funcoesDeTransacao.stream());
		result = funcoes.mapToDouble(Funcao::getContribuicao).sum();
		return result;
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
