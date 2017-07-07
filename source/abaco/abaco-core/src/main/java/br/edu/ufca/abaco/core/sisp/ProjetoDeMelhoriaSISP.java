package br.edu.ufca.abaco.core.sisp;

import javax.persistence.*;

import br.edu.ufca.abaco.core.*;

/**
 * Projeto de Melhoria definido pelo SISP 2.2.
 *
 * Um projeto de melhoria consiste em inclusao de novas funcionalidades, exclusao de funcionalidades,
 * alteraçao de funcionalidades em aplicaçoes implantadas em produçao e a contagem e feita atraves
 * da formula abaixo:
 *
 *<strong>PF_MELHORIA = PF_INCLUIDO + (FI x PF_ALTERADO) + (0.3 * PF_EXCLUIDO) + PF_CONVERSAO</strong>
 *
 * @author mario
 * kelvin
 *
 */

@Entity
@Table(schema = "sisp", name = "projeto_melhoria_sisp")
public class ProjetoDeMelhoriaSISP extends Projeto {

	private final double PESO_FUNCAO_EXCLUIDA = 0.3;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Contagem pfIncluido;
	@OneToOne
	private Contagem pfAlterado;
	@OneToOne
	private Contagem pfExcluido;
	@OneToOne
	private Contagem pfConversao;

	public ProjetoDeMelhoriaSISP(DetalheAnalise detalheAnalise) {
		super(detalheAnalise);

		pfIncluido = new Contagem();
		pfAlterado = new Contagem();
		pfExcluido = new Contagem();
		pfConversao = new Contagem();
	}

	@Override
	public double calculaTotal() {
		return pfIncluido.total() + pfAlterado.total() + (PESO_FUNCAO_EXCLUIDA * pfExcluido.total()) + pfConversao.total();
	}

	public boolean incluiFuncaoDeDadoPfIncluido(FuncaoDeDado funcaoDeDado){
    	return pfIncluido.addFuncaoDeDado(funcaoDeDado);
	}

	public boolean removeFuncaoDeDadoPfIncluido(FuncaoDeDado funcaoDeDado){
		return pfIncluido.removeFuncaoDeDado(funcaoDeDado);
	}

	public boolean incluiFuncaoDeTransacaoPfIncluido(FuncaoDeTransacao funcaoDeTransacao){
		return pfIncluido.addFuncaoDeTransacao(funcaoDeTransacao);
	}

	public boolean removeFuncaoDeTransacaoPfIncluido(FuncaoDeTransacao funcaoDeTransacao){
		return pfIncluido.removeFuncaoDeTransacao(funcaoDeTransacao);
	}


	public boolean incluiFuncaoDeDadoPfAlterado(FuncaoDeDado funcaoDeDado){
		return pfAlterado.addFuncaoDeDado(funcaoDeDado);
	}

	public boolean removeFuncaoDeDadoPfAlterado(FuncaoDeDado funcaoDeDado){
		return pfAlterado.removeFuncaoDeDado(funcaoDeDado);
	}

	public boolean incluiFuncaoDeTransacaoPfAlterado(FuncaoDeTransacao funcaoDeTransacao){
		return pfAlterado.addFuncaoDeTransacao(funcaoDeTransacao);
	}

	public boolean removeFuncaoDeTransacaoPfAlterado(FuncaoDeTransacao funcaoDeTransacao){
		return pfAlterado.removeFuncaoDeTransacao(funcaoDeTransacao);
	}

	public boolean incluiFuncaoDeDadoPfExcluido(FuncaoDeDado funcaoDeDado){
		return pfAlterado.addFuncaoDeDado(funcaoDeDado);
	}

	public boolean removeFuncaoDeDadoPfExcluido(FuncaoDeDado funcaoDeDado){
		return pfAlterado.removeFuncaoDeDado(funcaoDeDado);
	}

	public boolean incluiFuncaoDeTransacaoPfExcluido(FuncaoDeTransacao funcaoDeTransacao){
		return pfAlterado.addFuncaoDeTransacao(funcaoDeTransacao);
	}

	public boolean removeFuncaoDeTransacaoPfExcluido(FuncaoDeTransacao funcaoDeTransacao){
		return pfAlterado.removeFuncaoDeTransacao(funcaoDeTransacao);
	}

	public boolean incluiFuncaoDeDadoPfConversao(FuncaoDeDado funcaoDeDado){
		return pfAlterado.addFuncaoDeDado(funcaoDeDado);
	}

	public boolean removeFuncaoDeDadoPfConversao(FuncaoDeDado funcaoDeDado){
		return pfAlterado.removeFuncaoDeDado(funcaoDeDado);
	}

	public boolean incluiFuncaoDeTransacaoPfConversao(FuncaoDeTransacao funcaoDeTransacao){
		return pfAlterado.addFuncaoDeTransacao(funcaoDeTransacao);
	}

	public boolean removeFuncaoDeTransacaoPfConversao(FuncaoDeTransacao funcaoDeTransacao){
		return pfAlterado.removeFuncaoDeTransacao(funcaoDeTransacao);
	}

	@Override
	public Long getId() {
		return id;
	}

	public int totalFuncaoDeDados(){
		return pfIncluido.totalFuncoesDeDado() + pfConversao.totalFuncoesDeDado()
				+ pfExcluido.totalFuncoesDeDado() + pfAlterado.totalFuncoesDeTransacao();
	}

	public int totalFuncaoDeTransacao(){
		return pfIncluido.totalFuncoesDeTransacao() + pfExcluido.totalFuncoesDeTransacao()
				+ pfConversao.totalFuncoesDeTransacao() + pfAlterado.totalFuncoesDeTransacao();
	}
}
