package br.com.cactusteam.abaco.core.ifpug;

import javax.persistence.*;

import br.com.cactusteam.abaco.core.DetalheAnalise;
import br.com.cactusteam.abaco.core.FuncaoDeDado;
import br.com.cactusteam.abaco.core.FuncaoDeTransacao;
import br.com.cactusteam.abaco.core.Contagem;
import br.com.cactusteam.abaco.core.Projeto;

@Entity
@Table(name="projeto_desenvolvimento", schema = "ifpug")
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
		return pfIncluidos.totalizar();
	}

}
