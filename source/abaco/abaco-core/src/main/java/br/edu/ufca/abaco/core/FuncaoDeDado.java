package br.edu.ufca.abaco.core;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="funcao_dado")
public class FuncaoDeDado extends Funcao {

	private int tiposDeRegistros;
	private TipoFuncaoDado tipo;
	private int tiposDeDados;
	
	/**
	 * @deprecated usado apenas para JPA
	 */
	FuncaoDeDado(){}
	
	public FuncaoDeDado(int tipoDeRegistros, int tipoDeDados, TipoFuncaoDado tipo, String descricao) {
		super(descricao);
		this.tiposDeRegistros = tipoDeRegistros;
		this.tiposDeDados = tipoDeDados;
		this.tipo = tipo;
	}

	/**
	 * Cria uma nova função de dado de tipo ALI {@link TipoFuncaoDado} com valores defaults;
	 * <ul>
	 *     <il>tipos de registros com valor 0 (zero)</il>
	 *     <il>tipos de dados com valor 0 (zero</il>
	 *     <il>decrição vazia</il>
	 * </ul>
	 * @return
     */
	public static FuncaoDeDado novoArquivoLogicoInterno(){
		return new FuncaoDeDado(0,0,TipoFuncaoDado.ALI,"");
	}

	/**
	 * Cria uma nova função de dado de tipo AIE {@link TipoFuncaoDado} com valores defaults;
	 * <ul>
	 *     <il>tipos de registros com valor 0 (zero)</il>
	 *     <il>tipos de dados com valor 0 (zero</il>
	 *     <il>decrição vazia</il>
	 * </ul>
	 * @return
	 */
	public static FuncaoDeDado novoArquivoDeInterfaceExterna(){
		return new FuncaoDeDado(0,0,TipoFuncaoDado.AIE,"");
	}

	@Override
	public Complexidade getComplexidade() {
		if(tiposDeRegistros == 0 && tiposDeDados == 0)
			return Complexidade.BAIXA;
		else
			return CalculadoraDeComplexidade.calcula(this);
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
