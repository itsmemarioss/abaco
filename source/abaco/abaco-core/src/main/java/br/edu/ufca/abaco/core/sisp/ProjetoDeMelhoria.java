package br.edu.ufca.abaco.core.sisp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ufca.abaco.core.Contagem;
import br.edu.ufca.abaco.core.Projeto;

@Entity
public class ProjetoDeMelhoria extends Projeto {
	@OneToOne
	private Contagem pfIncluido;
	@OneToOne
	private Contagem pfAlterao;
	@OneToOne
	private Contagem pfExcluido;
	@OneToOne
	private Contagem pfConversao;

	@Override
	public double calculaTotal() {
		// TODO implementar cálculo
		return 0;
	}

}
