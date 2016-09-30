package br.com.mario.abaco.model;

public abstract class FuncaoDeDado extends Funcao {

	private int tipoDeRegistros;
	
	FuncaoDeDado(){}
	
	public FuncaoDeDado(int tipoDeRegistros, int tipoDeDados) {
		super();
		this.tipoDeRegistros = tipoDeRegistros;
		this.tipoDeDados = tipoDeDados;
	}

	@Override
	public Complexidade getComplexidade() {
		return CalculaComplexidade.calcula(this);
	}

	public abstract int getContribuicao();

	public int getTipoDeRegistros() {
		return tipoDeRegistros;
	}

}
