package br.com.mario.abaco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Funcao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String descricao;
	private String observacao;
	int tipoDeDados;
	
	/**
	 * Calcula a complexidade da função baseado nos valores dos tipos de dados e no 
	 * tipo de registro/arquivos referenciados.
	 * Caso não seja informado tais valores a complexidade retornada será BAIXA para funções de dados 
	 * e MEDIA para funções de transação conforme regras da contagem antecipada da NESMA.
	 * @return
	 */
	public abstract Complexidade getComplexidade();
	public abstract int getContribuicao();
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setTipoDeDados(int tipoDeDados) {
		this.tipoDeDados = tipoDeDados;
	}
	public int getTipoDeDados() {
		return tipoDeDados;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
