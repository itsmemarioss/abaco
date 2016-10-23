package br.com.mario.abaco.model.sisp2_2;

import java.util.List;

import javax.persistence.Entity;

import br.com.mario.abaco.model.Contagem;
import br.com.mario.abaco.model.FuncaoDeDado;
import br.com.mario.abaco.model.FuncaoDeTransacao;
import br.com.mario.abaco.model.Projeto;

@Entity
public class ProjetoDeAplicacao extends Projeto{
	
	public ProjetoDeAplicacao() {
		getContagens().add(new Contagem("Pontos de Função instalados"));
	}

	public void addFuncaoDeDado(FuncaoDeDado funcao){
		getContagens().get(0).addFuncaoDeDado(funcao);
	}
	
	public void addFuncaoDeTransacao(FuncaoDeTransacao funcao){
		getContagens().get(0).addFuncaoDeTransacao(funcao);
	}

	public List<FuncaoDeDado> getArquivos(){
		return getContagens().get(0).getArquivos();
	}
	
	public List<FuncaoDeTransacao> getTransacoes(){
		return getContagens().get(0).getFuncoesDeTransacao();
	}

	@Override
	public double total() {
		return getContagens().stream().mapToDouble(Contagem::total).sum();
	}
	
}
