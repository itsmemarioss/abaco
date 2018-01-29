package br.com.cactusteam.abaco.core;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="funcao_transacao")
public class FuncaoDeTransacao extends Funcao {

	/*
		TODO remover e usar tamanho do Set para detalhar contagem
	 */
	private int arquivosReferenciados;
	private TipoFuncaoTransacao tipo;
	private int tiposDeDados;
	
	/**
	 * @deprecated usado apenas para JPA
	 */
	FuncaoDeTransacao(){}

	/**
	 * Construtor com {@link Situacao} padrao INCLUIDO
	 *
	 * @param arquivosReferenciados
	 * @param tiposDeDados
	 * @param tipo
	 * @param descricao
	 */
	public FuncaoDeTransacao(int arquivosReferenciados, int tiposDeDados, TipoFuncaoTransacao tipo, String descricao) {
		super(descricao, Situacao.INCLUIDO);
		this.arquivosReferenciados = arquivosReferenciados;
		this.tiposDeDados = tiposDeDados;
		this.tipo = tipo;
	}


	public FuncaoDeTransacao(int arquivosReferenciados, int tiposDeDados, TipoFuncaoTransacao tipo, String descricao, Situacao situacao) {
		super(descricao, situacao);
		this.arquivosReferenciados = arquivosReferenciados;
		this.tiposDeDados = tiposDeDados;
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
			return CalculadoraDeComplexidade.calcula(this);
	}

	public TipoFuncaoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncaoTransacao tipo) {
		this.tipo = tipo;
	}

	public void setArquivosReferenciados(int arquivosReferenciados) {
		this.arquivosReferenciados = arquivosReferenciados;
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
		result = prime * result + arquivosReferenciados;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + tiposDeDados;
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
		FuncaoDeTransacao other = (FuncaoDeTransacao) obj;
		if (arquivosReferenciados != other.arquivosReferenciados)
			return false;
		if (tipo != other.tipo)
			return false;
		if (tiposDeDados != other.tiposDeDados)
			return false;
		if (!getDescricao().equals(other.getDescricao()))
			return false;
		return true;
	}


	public static FuncaoDeTransacao novaEntradaExterna() {
		return new FuncaoDeTransacao(0,0,TipoFuncaoTransacao.EE,"Nova EE", Situacao.INCLUIDO);
	}

	public static FuncaoDeTransacao novaSaidaExterna() {
		return new FuncaoDeTransacao(0,0,TipoFuncaoTransacao.SE,"Nova SE", Situacao.INCLUIDO);
	}

	public static FuncaoDeTransacao novaConsultaExterna() {
		return new FuncaoDeTransacao(0,0,TipoFuncaoTransacao.CE,"Nova CE", Situacao.INCLUIDO);
	}
}
