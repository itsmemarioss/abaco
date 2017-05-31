package br.edu.ufca.abaco.core.ifpug;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ufca.abaco.core.Contagem;
import br.edu.ufca.abaco.core.DetalheAnalise;
import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.FuncaoDeTransacao;
import br.edu.ufca.abaco.core.Projeto;

@Entity(name="projeto_desenvolvimento")
public class ProjetoDeDesenvolvimento extends Projeto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Contagem pfIncluidos;
	
	public ProjetoDeDesenvolvimento() {
		pfIncluidos = new Contagem();
	}
	
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

}
