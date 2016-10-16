package br.com.mario.abaco.model.sisp2_2;

import br.com.mario.abaco.model.Projeto;

public class ProjetoFactory {
	public static Projeto criar(TipoContagemSISP tipo){
		Projeto retorno = null;
		switch (tipo) {
		case APLICACAO:
			retorno = new ProjetoDeAplicacao();
			break;
		case MELHORIA:
			retorno = new ProjetoDeMelhoria();
			break;
		case DESENVOLVIMENTO:
			retorno = new ProjetoDeDesenvolvimento();
			break;
		case MIGRACAO:
			retorno = new ProjetoDeMigracao();
			break;
		default:
			break;
		}
		return retorno;
	}
}
