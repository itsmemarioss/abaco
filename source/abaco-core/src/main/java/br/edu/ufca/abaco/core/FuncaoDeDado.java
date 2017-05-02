package br.edu.ufca.abaco.core;

import javax.persistence.Entity;

@Entity
public class FuncaoDeDado extends Funcao {

	private int tiposDeRegistros;
	private TipoFuncaoDado tipo;
	private int tiposDeDados;
	
	/**
	 * @deprecated usado apenas para JPA
	 */
	FuncaoDeDado(){}
	
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

	public int getTiposDeDados() {
		return tiposDeDados;
	}

	public void setTiposDeDados(int tiposDeDados) {
		this.tiposDeDados = tiposDeDados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + tiposDeDados;
		result = prime * result + tiposDeRegistros;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncaoDeDado other = (FuncaoDeDado) obj;
		if (tipo != other.tipo)
			return false;
		if (tiposDeDados != other.tiposDeDados)
			return false;
		if (tiposDeRegistros != other.tiposDeRegistros)
			return false;
		return true;
	}
	
	

}
