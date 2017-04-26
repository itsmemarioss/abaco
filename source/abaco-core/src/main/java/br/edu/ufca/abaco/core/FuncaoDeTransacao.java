package br.edu.ufca.abaco.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class FuncaoDeTransacao extends Funcao {
	
	//remover e usar tamanho do Set
	private int arquivosReferenciados;
	private transient Set<FuncaoDeDado> arquivos = new HashSet<>();
	private TipoFuncaoTransacao tipo;
	
	public FuncaoDeTransacao(){}

	public FuncaoDeTransacao(int arquivosReferenciados, int tipoDeDados, TipoFuncaoTransacao tipo) {
		super();
		this.arquivosReferenciados = arquivosReferenciados;
		setTiposDeDados(tipoDeDados);
		this.tipo = tipo;
	}

	public int getArquivosReferenciados() {
		return arquivosReferenciados;
	}
	
	@Override
	public Complexidade getComplexidade() {
		if(arquivosReferenciados == 0 && getTiposDeDados() == 0)
			return Complexidade.MEDIA;
		else
			return CalculaComplexidade.calcula(this);
	}

	public Set<FuncaoDeDado> getArquivos() {
		return Collections.unmodifiableSet(arquivos);
	}
	
	public boolean adicionaArquivo(FuncaoDeDado arquivo){
		return arquivos.add(arquivo);
	}

	public TipoFuncaoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncaoTransacao tipo) {
		this.tipo = tipo;
	}

	@Override
	public int getContribuicao() {
		return CalculaContribuicao.calcula(this);
	}

	public void setArquivosReferenciados(int arquivosReferenciados) {
		this.arquivosReferenciados = arquivosReferenciados;
	}
	
}
