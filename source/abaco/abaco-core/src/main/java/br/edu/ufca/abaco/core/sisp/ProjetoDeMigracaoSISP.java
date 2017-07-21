package br.edu.ufca.abaco.core.sisp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
public class ProjetoDeMigracaoSISP extends Projeto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Contagem pfIncluidos;
	
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

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int totalFuncoesDeDado() {
		return pfIncluidos.totalFuncoesDeDado();
	}

	public int totalFuncoesDeTransacao() {
		return pfIncluidos.totalFuncoesDeTransacao();
	}

}
