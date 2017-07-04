package br.edu.ufca.abaco.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.edu.ufca.abaco.core.dao.BaseEntity;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Funcao implements BaseEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String descricao;
	private String observacao;
	private float fatorImpacto = 1;
	
	/**
	 * Calcula a complexidade da função baseado nos valores dos tipos de dados e no 
	 * tipo de registro/arquivos referenciados.
	 * Caso não seja informado tais valores, a complexidade retornada deverá ser BAIXA para funções de dados 
	 * e MEDIA para funções de transação conforme regras da contagem antecipada da NESMA.
	 * 
	 * @return {@link Complexidade}
	 */
	public abstract Complexidade getComplexidade();
	public abstract float getContribuicao();
	
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
