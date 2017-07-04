package br.edu.ufca.abaco.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.edu.ufca.abaco.core.dao.BaseEntity;

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
	
	@OneToMany
	@JoinColumn(name="contagem_id")
	private Set<FuncaoDeDado> funcoesDeDado;
	
	@OneToMany
	@JoinColumn(name="contagem_id")
	private Set<FuncaoDeTransacao> funcoesDeTransacao;
	
	private float fatorDeImpacto;
	
	public Contagem() {
		this(1);//cria com fator de impacto 1
	}
	
	public Contagem(float fatorDeImpacto) {
		this.fatorDeImpacto = fatorDeImpacto;
		funcoesDeDado = new HashSet<>();
		funcoesDeTransacao = new HashSet<>();
	}
	
	public double total(){
		int result = 0;
		Stream<Funcao> funcoes = Stream.concat(funcoesDeDado.stream(), funcoesDeTransacao.stream());
		result = funcoes.mapToInt(Funcao::getContribuicao).sum();
		return result*fatorDeImpacto;
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
	public float getFatorDeImpacto() {
		return fatorDeImpacto;
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
