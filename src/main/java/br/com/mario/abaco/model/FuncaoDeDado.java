package br.com.mario.abaco.model;

public class FuncaoDeDado extends Funcao {

	private int tipoDeRegistros;
	private TipoFuncaoDado tipo;
	
	public FuncaoDeDado(){}
	
	public FuncaoDeDado(int tipoDeRegistros, int tipoDeDados) {
		super();
		this.tipoDeRegistros = tipoDeRegistros;
		this.tipoDeDados = tipoDeDados;
	}

	@Override
	public Complexidade getComplexidade() {
		return CalculaComplexidade.calcula(this);
	}

	public int getContribuicao(){
		return 0;
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
