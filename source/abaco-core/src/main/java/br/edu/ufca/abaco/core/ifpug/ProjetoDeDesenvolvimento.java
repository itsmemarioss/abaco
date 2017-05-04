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
public class ProjetoDeDesenvolvimento implements Projeto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Contagem pontosDeFuncaoIncluidos;
	
	@OneToOne
	private DetalheAnalise detalhes;
	
	public ProjetoDeDesenvolvimento() {
		pontosDeFuncaoIncluidos = new Contagem();
	}
	
	public void incluiFuncaoDeDado(FuncaoDeDado funcao){
		pontosDeFuncaoIncluidos.addFuncaoDeDado(funcao);
	}
	
	public void incluiFuncaoDeTransacao(FuncaoDeTransacao funcao){
		pontosDeFuncaoIncluidos.addFuncaoDeTransacao(funcao);
	}
	
	@Override
	public double calculaTotal() {
		return pontosDeFuncaoIncluidos.total();
	}

}
