package br.edu.ufca.abaco.core.sisp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.FuncaoDeTransacao;
import br.edu.ufca.abaco.core.TipoFuncaoDado;
import br.edu.ufca.abaco.core.TipoFuncaoTransacao;

public class ProjetoDeMigracaoTest {

	ProjetoDeMigracao projeto; 
	
	@Before
	public void setup(){
		projeto = new ProjetoDeMigracao();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirInclusaoDeAIE(){
		projeto.incluiFuncaoDeDado(new FuncaoDeDado(0, 0, TipoFuncaoDado.AIE));
	}
	
	@Test
	public void deveExcluirFuncoes(){
		FuncaoDeDado dado = new FuncaoDeDado(0, 0, TipoFuncaoDado.ALI);
		FuncaoDeTransacao transacao = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.EE); 
		
		projeto.incluiFuncaoDeDado(dado);
		projeto.removeFuncaoDeDado(dado);
		assertEquals(0, projeto.totalFuncoesDeDado());
		
		projeto.incluiFuncaoDeTransacao(transacao);
		projeto.removeFuncaoDeTransacao(transacao);
		assertEquals(0, projeto.totalFuncoesDeTransacao());
	}
	
}
