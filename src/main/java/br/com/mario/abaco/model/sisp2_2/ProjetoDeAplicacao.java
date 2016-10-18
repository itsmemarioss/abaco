package br.com.mario.abaco.model.sisp2_2;

import java.util.List;

import javax.persistence.Entity;

import br.com.mario.abaco.model.Contagem;
import br.com.mario.abaco.model.FuncaoDeDado;
import br.com.mario.abaco.model.FuncaoDeTransacao;
import br.com.mario.abaco.model.Projeto;

@Entity
public class ProjetoDeAplicacao extends Projeto{
	
	private transient Contagem pfInstalados = new Contagem("Pontos de Função instalados");
	private boolean encerrado;

	@Override
	public void encerrarContagem() {
		if (!encerrado) {
			addContagem(pfInstalados);
			encerrado = true;
		}
	}
	
	public void addFuncaoDeDado(FuncaoDeDado funcao){
		pfInstalados.addFuncaoDeDado(funcao);
	}
	
	public void addFuncaoDeTransacao(FuncaoDeTransacao funcao){
		pfInstalados.addFuncaoDeTransacao(funcao);
	}

	public List<FuncaoDeDado> getArquivos(){
		return pfInstalados.getArquivos();
	}
	
	public List<FuncaoDeTransacao> getTransacoes(){
		return pfInstalados.getFuncoesDeTransacao();
	}

	@Override
	public double total() {
		return getContagens().stream().mapToDouble(Contagem::total).sum();
	}
	
}
