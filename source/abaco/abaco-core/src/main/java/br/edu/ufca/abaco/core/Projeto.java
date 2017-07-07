package br.edu.ufca.abaco.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import br.edu.ufca.abaco.core.dao.BaseEntity;

/**
 * Classe usada como base para os representação das análises de pontos de função.
 * 
 * @author mario
 *
 */
@MappedSuperclass
public abstract class Projeto implements BaseEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private DetalheAnalise detalhes;
	
	public abstract double calculaTotal();
	
	public DetalheAnalise getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(DetalheAnalise detalhes) {
		this.detalhes = detalhes;
	}	
	
	@Override
	public Long getId() {
		return id;
	}

	public Projeto(DetalheAnalise detalhes) {
		super();
		this.detalhes = detalhes;
	}
	
	
}
