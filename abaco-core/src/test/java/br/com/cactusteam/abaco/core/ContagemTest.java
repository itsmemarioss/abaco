package br.com.cactusteam.abaco.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContagemTest {
	
	private Contagem contagem;
	
	@Before
	public void setup(){
		contagem = new Contagem();
	}
	
	@Test
	public void naoDeveAdicionarFuncoesJaExistentes(){
		//FuncaoDeDado
		FuncaoDeDado aie = new FuncaoDeDado(2,3,TipoFuncaoDado.AIE,"");
		FuncaoDeTransacao ee = new FuncaoDeTransacao(2,3,TipoFuncaoTransacao.EE,"");
		
		contagem.addFuncaoDeDado(aie);
		contagem.addFuncaoDeDado(aie);
		contagem.addFuncaoDeTransacao(ee);
		contagem.addFuncaoDeTransacao(ee);
		
		assertEquals(1, contagem.totalFuncoesDeDado());
		assertEquals(1, contagem.totalFuncoesDeTransacao());
		
	}
	
}
