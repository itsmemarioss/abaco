package br.com.mario.abaco.model.sisp2_2;

import javax.persistence.Entity;

import br.com.mario.abaco.model.Contagem;
import br.com.mario.abaco.model.Projeto;

@Entity
public class ProjetoDeDesenvolvimento extends Projeto{

	public ProjetoDeDesenvolvimento() {
		getContagens().add(new Contagem("PF Incluídos"));
		getContagens().add(new Contagem("PF de Conversão",true));
	}

	
}
