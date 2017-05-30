package br.edu.ufca.abaco.core.sisp;

import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.Projeto;
import br.edu.ufca.abaco.core.TipoFuncaoDado;
import br.edu.ufca.abaco.core.ifpug.ProjetoDeDesenvolvimento;

/**
 * Projeto de migração definida pelo SISP 2.2.
 * 
 * Os projetos de migração de dados devem ser contados como um novo projeto de 
 * desenvolvimento de um sistema, seguindo a fórmula abaixo:
 * 
 * <strong>PF_CONVERSÃO = PF_INCLUIDO</strong>
 * 
 * Ver {@link ProjetoDeDesenvolvimento}
 * 
 * @author mario
 *
 */
public class ProjetoDeMigracao extends ProjetoDeDesenvolvimento implements Projeto {
	
	@Override
	public void incluiFuncaoDeDado(FuncaoDeDado funcao) {
		if(funcao.getTipo() == TipoFuncaoDado.ALI )
			super.incluiFuncaoDeDado(funcao);
		else
			throw new IllegalArgumentException("Projetos de migração não podem conter Arquivos Interface Externa.");
	}
}
