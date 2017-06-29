package br.edu.ufca.abaco.core.sisp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ufca.abaco.core.Contagem;
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
 * @author mario
 *
 */
@Entity(name="projeto_migracao")
public class ProjetoDeMigracao extends Projeto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Contagem pfIncluidos;
	
	public void incluiFuncaoDeDado(FuncaoDeDado funcao) {
		if(funcao.getTipo() == TipoFuncaoDado.ALI )
			pfIncluidos.addFuncaoDeDado(funcao);
		else
			throw new IllegalArgumentException("Projetos de migração não podem conter Arquivos Interface Externa.");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contagem getPfIncluidos() {
		return pfIncluidos;
	}

	public void setPfIncluidos(Contagem pfIncluidos) {
		this.pfIncluidos = pfIncluidos;
	}

	@Override
	public double calculaTotal() {
		return pfIncluidos.total();
	}
}
