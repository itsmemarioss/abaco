package br.edu.ufca.abaco.core.ifpug;

import javax.persistence.*;

import br.edu.ufca.abaco.core.Contagem;
import br.edu.ufca.abaco.core.DetalheAnalise;
import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.FuncaoDeTransacao;
import br.edu.ufca.abaco.core.Projeto;

@Entity(name="projeto_desenvolvimento_ifpug")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProjetoDeDesenvolvimento extends Projeto{
	
	@OneToOne
	private Contagem pfIncluidos;
	
	public ProjetoDeDesenvolvimento(DetalheAnalise detalhe) {
		super(detalhe);
		pfIncluidos = new Contagem();
	}

	/**
	 * @deprecated apenas para usos de frameworks
	 */
	public ProjetoDeDesenvolvimento(){}
	
	public void incluiFuncaoDeDado(FuncaoDeDado funcao){
		pfIncluidos.addFuncaoDeDado(funcao);
	}
	
	public void incluiFuncaoDeTransacao(FuncaoDeTransacao funcao){
		pfIncluidos.addFuncaoDeTransacao(funcao);
	}
	
	@Override
	public double calculaTotal() {
		return pfIncluidos.total();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

}
