package br.edu.ufca.abaco.core;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Classe usada como base para os representação das análises de pontos de função.
 * 
 * @author mario
 *
 */
@MappedSuperclass
public abstract class Projeto {
	
	@OneToOne
	private DetalheAnalise detalhes;
	
	public abstract double calculaTotal();
	
	public DetalheAnalise getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(DetalheAnalise detalhes) {
		this.detalhes = detalhes;
	}	
	
}
