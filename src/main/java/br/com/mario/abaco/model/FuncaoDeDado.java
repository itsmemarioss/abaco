package br.com.mario.abaco.model;

import javax.persistence.Entity;

@Entity
public class FuncaoDeDado extends Funcao {

	private int tipoDeRegistros;
	private TipoFuncaoDado tipo;
	
	public FuncaoDeDado(){}
	
	public FuncaoDeDado(int tipoDeRegistros, int tipoDeDados, TipoFuncaoDado tipo) {
		super();
		this.tipoDeRegistros = tipoDeRegistros;
		this.tipoDeDados = tipoDeDados;
		this.tipo = tipo;
	}

	@Override
	public Complexidade getComplexidade() {
		if(tipoDeRegistros == 0 && tipoDeDados == 0)
			return Complexidade.BAIXA;
		else
			return CalculaComplexidade.calcula(this);
	}

	public int getContribuicao(){
		return CalculaContribuicao.calcula(this);
	}

	public int getTipoDeRegistros() {
		return tipoDeRegistros;
	}

	public TipoFuncaoDado getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncaoDado tipo) {
		this.tipo = tipo;
	}

	public void setTipoDeRegistros(int tipoDeRegistros) {
		this.tipoDeRegistros = tipoDeRegistros;
	}

}
