package br.edu.ufca.abaco.core;

import javax.persistence.*;

/**
 * Classe usada como base para os representação das análises de pontos de função.
 * 
 * @author mario
 *
 */
public abstract class Projeto implements BaseEntity<Long>{
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private DetalheAnalise detalhes;
	
	public abstract double calculaTotal();
	
	public DetalheAnalise getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(DetalheAnalise detalhes) {
		this.detalhes = detalhes;
	}	
	
	/**
	 * @deprecated apenas para usos de frameworks
	 */
	public Projeto(){}

	public Projeto(DetalheAnalise detalhes) {
		super();
		this.detalhes = detalhes;
	}
	
	
}
