package br.edu.ufca.abaco.core.sisp;

import javax.persistence.*;

import br.edu.ufca.abaco.core.Contagem;
import br.edu.ufca.abaco.core.DetalheAnalise;
import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.FuncaoDeTransacao;
import br.edu.ufca.abaco.core.Projeto;
import br.edu.ufca.abaco.core.TipoFuncaoDado;

import java.util.Set;

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
@Entity
@Table(name="projeto_migracao_sisp")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProjetoDeMigracaoSISP extends Projeto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Contagem pfIncluidos;

	/**
	 * @deprecated apenas para usos de frameworks
	 */
	public ProjetoDeMigracaoSISP(){}

	public ProjetoDeMigracaoSISP(DetalheAnalise detalhe) {
		super(detalhe);
		pfIncluidos = new Contagem();
	}
	
	public boolean incluiFuncaoDeDado(FuncaoDeDado funcao) {
		if(funcao.getTipo() == TipoFuncaoDado.ALI )
			return pfIncluidos.addFuncaoDeDado(funcao);
		else
			throw new IllegalArgumentException("Projetos de migração não podem conter Arquivos Interface Externa.");
	}
	
	public boolean incluiFuncaoDeTransacao(FuncaoDeTransacao funcao){
		return pfIncluidos.addFuncaoDeTransacao(funcao);
	}
	
	public boolean removeFuncaoDeDado(FuncaoDeDado funcao){
		return pfIncluidos.removeFuncaoDeDado(funcao);
	}
	
	public boolean removeFuncaoDeTransacao(FuncaoDeTransacao funcao){
		return pfIncluidos.removeFuncaoDeTransacao(funcao);
	}

	public Set<FuncaoDeDado> getFuncoesDeDados(){
		return pfIncluidos.getFuncoesDeDado();
	}

	public Set<FuncaoDeTransacao> getFuncoesDeTransacao(){
		return pfIncluidos.getFuncoesDeTransacao();
	}
	
	@Override
	public double calculaTotal() {
		return pfIncluidos.total();
	}

	public int totalFuncoesDeDado() {
		return pfIncluidos.totalFuncoesDeDado();
	}

	public int totalFuncoesDeTransacao() {
		return pfIncluidos.totalFuncoesDeTransacao();
	}

	@Override
	public Long getId() {
		return id;
	}
}
