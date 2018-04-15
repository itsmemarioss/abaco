package br.com.cactusteam.abaco.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraDeComplexidadeTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void deveRetornarExecaoParaTipoDeRegistroComValorZero(){
		CalculadoraDeComplexidade.calcula(new FuncaoDeDado(0, 1, TipoFuncaoDado.ALI,""));
	}
	
	@Test
	public void deveRetornarComplexidadeBaixaParaArquivos(){
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(1, 19, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(5, 19, TipoFuncaoDado.AIE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(2, 19, TipoFuncaoDado.ALI,"")));
		
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(1, 20, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(1, 25, TipoFuncaoDado.AIE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(1, 50, TipoFuncaoDado.ALI,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeMediaParaArquivos(){
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(1, 51, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(1, 55, TipoFuncaoDado.AIE,"")));
		
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(2, 30, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(3, 21, TipoFuncaoDado.AIE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(4, 50, TipoFuncaoDado.ALI,"")));
		
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(7, 19, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(10, 1, TipoFuncaoDado.AIE,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeAltaParaArquivos(){
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(2, 51, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(3, 51, TipoFuncaoDado.AIE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(5, 60, TipoFuncaoDado.AIE,"")));
		
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(5, 60, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(5, 70, TipoFuncaoDado.ALI,"")));
		
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(6, 20, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(6, 40, TipoFuncaoDado.ALI,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeDado(8, 60, TipoFuncaoDado.ALI,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeBaixaParaEntradasExternas(){
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 4, TipoFuncaoTransacao.EE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 3, TipoFuncaoTransacao.EE,"")));
		
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 3, TipoFuncaoTransacao.EE,"")));
		
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 13, TipoFuncaoTransacao.EE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 15, TipoFuncaoTransacao.EE,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeMediaParaEntradasExternas(){
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 16, TipoFuncaoTransacao.EE,"")));
		
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 5, TipoFuncaoTransacao.EE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 15, TipoFuncaoTransacao.EE,"")));
		
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(3, 1, TipoFuncaoTransacao.EE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(5, 4, TipoFuncaoTransacao.EE,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeAltaParaEntradasExternas(){
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 16, TipoFuncaoTransacao.EE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 17, TipoFuncaoTransacao.EE,"")));
		
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(3, 5, TipoFuncaoTransacao.EE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(4, 8, TipoFuncaoTransacao.EE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(3, 16, TipoFuncaoTransacao.EE,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeBaixaParaSaidasEConsultasExternas(){
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 4, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 4, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 5, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 5, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 6, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 6, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 19, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 19, TipoFuncaoTransacao.CE,"")));
		
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 5, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 4, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(3, 5, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.BAIXA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(3, 4, TipoFuncaoTransacao.CE,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeMediaParaSaidasEConsultasExternas(){
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 20, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 21, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(1, 21, TipoFuncaoTransacao.CE,"")));
		
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 6, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(3, 17, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 19, TipoFuncaoTransacao.CE,"")));
		
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(4, 4, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(4, 4, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(5, 5, TipoFuncaoTransacao.SE,"")));
		assertEquals(Complexidade.MEDIA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(7, 5, TipoFuncaoTransacao.CE,"")));
	}
	
	@Test
	public void deveRetornarComplexidadeAltaParaSaidasEConsultasExternas(){
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(2, 20, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(3, 21, TipoFuncaoTransacao.CE,"")));
		
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(4, 6, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(4, 7, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(5, 8, TipoFuncaoTransacao.CE,"")));
		assertEquals(Complexidade.ALTA, CalculadoraDeComplexidade.calcula(new FuncaoDeTransacao(7, 19, TipoFuncaoTransacao.CE,"")));
	}

}
