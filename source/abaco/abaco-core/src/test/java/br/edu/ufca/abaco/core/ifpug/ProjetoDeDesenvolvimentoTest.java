package br.edu.ufca.abaco.core.ifpug;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjetoDeDesenvolvimentoTest {

	private ProjetoDeDesenvolvimento projeto;
	
	@Before
	public void setup(){
		projeto = new ProjetoDeDesenvolvimento();
	}
	
	@Test
	public void deveCalcularTotalDoProjeto(){
		assertEquals(0, projeto.calculaTotal(),0);
	}
	
	@Test
	public void deveCalcularTotalSegundoEstimativaNESMA(){
		
	}
}
