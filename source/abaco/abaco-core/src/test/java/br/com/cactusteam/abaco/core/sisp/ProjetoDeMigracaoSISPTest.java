package br.com.cactusteam.abaco.core.sisp;

import br.com.cactusteam.abaco.core.FuncaoDeDado;
import br.com.cactusteam.abaco.core.FuncaoDeTransacao;
import br.com.cactusteam.abaco.core.TipoFuncaoDado;
import br.com.cactusteam.abaco.core.TipoFuncaoTransacao;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProjetoDeMigracaoSISPTest {

	ProjetoDeMigracaoSISP projeto;
	
	@Before
	public void setup(){
		projeto = new ProjetoDeMigracaoSISP(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirInclusaoDeAIE(){
		projeto.incluiFuncaoDeDado(new FuncaoDeDado(0, 0, TipoFuncaoDado.AIE,""));
	}
	
	@Test
	public void deveExcluirFuncoes(){
		FuncaoDeDado dado = new FuncaoDeDado(0, 0, TipoFuncaoDado.ALI,"");
		FuncaoDeTransacao transacao = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.EE,"");
		
		projeto.incluiFuncaoDeDado(dado);
		projeto.removeFuncaoDeDado(dado);
		assertEquals(0, projeto.totalFuncoesDeDado());
		
		projeto.incluiFuncaoDeTransacao(transacao);
		projeto.removeFuncaoDeTransacao(transacao);
		assertEquals(0, projeto.totalFuncoesDeTransacao());
	}
	
}
