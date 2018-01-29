package br.com.cactusteam.abaco.core.sisp;

import javax.persistence.*;

import br.com.cactusteam.abaco.core.*;

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
 * @author kelvin
 *
 */

@Entity
@Table(name = "projeto_melhoria", schema = "sisp")
public class ProjetoDeMelhoriaSISP extends Projeto {

	private final double PESO_FUNCAO_EXCLUIDA = 0.3;

	@OneToOne
	private Contagem pfContagem;

	/**
	 * @deprecated  uso exclusivo de frameworks
	 */
	public ProjetoDeMelhoriaSISP(){}

	public ProjetoDeMelhoriaSISP(DetalheAnalise detalheAnalise) {
		super(detalheAnalise);

		pfContagem = new Contagem();
	}

	public boolean incluiFuncaoDeDado(FuncaoDeDado funcaoDeDado){
		return pfContagem.addFuncaoDeDado(funcaoDeDado);
	}

	public boolean incluiFuncaoDeTransacao(FuncaoDeTransacao funcaoDeTransacao){
		return pfContagem.addFuncaoDeTransacao(funcaoDeTransacao);
	}

	@Override
	public double calculaTotal() {
		double totalIncluido = pfContagem.totalizarPorSituacao(Situacao.INCLUIDO);
		double totalAlterado = pfContagem.totalizarPorSituacao(Situacao.ALTERADO);
		double totalExcluido = pfContagem.totalizarPorSituacao(Situacao.EXCLUIDO);
		double totalConversao = pfContagem.totalizarPorSituacao(Situacao.CONVERSAO);

		return totalIncluido + totalAlterado + totalExcluido + totalConversao;
	}
}
