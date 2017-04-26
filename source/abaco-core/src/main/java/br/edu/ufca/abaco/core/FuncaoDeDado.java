package br.edu.ufca.abaco.core;

import javax.persistence.Entity;

@Entity
public class FuncaoDeDado extends Funcao {

	private int tiposDeRegistros;
	private TipoFuncaoDado tipo;
	
	
	public FuncaoDeDado(){}
	
	public FuncaoDeDado(int tipoDeRegistros, int tipoDeDados, TipoFuncaoDado tipo) {
		super();
		this.tiposDeRegistros = tipoDeRegistros;
		this.tiposDeDados = tipoDeDados;
		this.tipo = tipo;
	}

	@Override
	public Complexidade getComplexidade() {
		if(tiposDeRegistros == 0 && tiposDeDados == 0)
			return Complexidade.BAIXA;
		else
			return CalculaComplexidade.calcula(this);
	}

	public int getContribuicao(){
		return CalculaContribuicao.calcula(this);
	}

	public int getTiposDeRegistros() {
		return tiposDeRegistros;
	}

	public TipoFuncaoDado getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncaoDado tipo) {
		this.tipo = tipo;
	}

	public void setTiposDeRegistros(int tiposDeRegistros) {
		this.tiposDeRegistros = tiposDeRegistros;
	}

}
