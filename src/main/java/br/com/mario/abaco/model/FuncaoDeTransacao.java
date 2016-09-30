package br.com.mario.abaco.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class FuncaoDeTransacao extends Funcao {
	
	private int arquivosReferenciados;
	private Set<FuncaoDeDado> arquivos;

	public FuncaoDeTransacao(int arquivosReferenciados, int tipoDeDados) {
		super();
		this.arquivosReferenciados = arquivosReferenciados;
		this.tipoDeDados = tipoDeDados;
		arquivos = new HashSet<>();
	}

	public int getArquivosReferenciados() {
		return arquivosReferenciados;
	}
	
	@Override
	public Complexidade getComplexidade() {
		return CalculaComplexidade.calcula(this);
	}

	public Set<FuncaoDeDado> getArquivos() {
		return Collections.unmodifiableSet(arquivos);
	}
	
	public boolean adicionaArquivo(FuncaoDeDado arquivo){
		return arquivos.add(arquivo);
	}
	
	
}
