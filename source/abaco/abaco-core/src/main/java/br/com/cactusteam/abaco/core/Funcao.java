package br.com.cactusteam.abaco.core;

import javax.persistence.*;

/**
 * Classe base das Funções de Dados e Transação, define atributos comuns e comportamentos padrão.
 *
 * @author mario
 *
 * @see FuncaoDeDado
 * @see FuncaoDeTransacao
 */
@MappedSuperclass
public abstract class Funcao implements BaseEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String descricao;
	private String observacao;
	private float fatorImpacto = 1;

	/**
	 * @deprecated usado apenas para JPA
	 */
	Funcao() {}

	public Funcao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Calcula a complexidade da função baseado nos valores dos tipos de dados e no 
	 * tipo de registro/arquivos referenciados.
	 * Caso não seja informado tais valores, a complexidade retornada deverá ser BAIXA para funções de dados 
	 * e MEDIA para funções de transação conforme regras da contagem antecipada da NESMA.
	 * 
	 * @return {@link Complexidade}
	 */
	public abstract Complexidade getComplexidade();

	/**
	 * Calcula a contribuição em pontos de função baseado nos valores dos tipos de dados e no
	 * tipo de registro/arquivos referenciados e complexidade.
	 * Usa internamente a função {@code getComplexidade}
	 * 
	 */
	public float getContribuicao(){
		return CalculadoraDeContribuicao.calcula(this) * getFatorImpacto();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	public float getFatorImpacto() {
		return fatorImpacto;
	}
	
	public void setFatorImpacto(float fatorImpacto) {
		this.fatorImpacto = fatorImpacto;
	}

}
