package br.com.mario.abaco.model;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Ignore;

import static br.com.mario.abaco.model.CalculaComplexidade.*;

public class CalculaComplexidadeTeste {
	
	@Test(expected=IllegalArgumentException.class)
	public void deveRetornarExecaoParaTipoDeRegistroComValorZero(){
		calcula(new ArquivoLogicoInterno(0, 1));
	}
	
	@Test
	public void deveRetornarComplexidadeBaixaParaArquivos(){
		assertEquals(Complexidade.BAIXA, calcula(new ArquivoLogicoInterno(1, 19)));
		assertEquals(Complexidade.BAIXA, calcula(new ArquivoDeInterfaceExterna(5, 19)));
		assertEquals(Complexidade.BAIXA, calcula(new ArquivoLogicoInterno(2, 19)));
		
		assertEquals(Complexidade.BAIXA, calcula(new ArquivoLogicoInterno(1, 20)));
		assertEquals(Complexidade.BAIXA, calcula(new ArquivoDeInterfaceExterna(1, 25)));
		assertEquals(Complexidade.BAIXA, calcula(new ArquivoLogicoInterno(1, 50)));
	}
	
	@Test
	public void deveRetornarComplexidadeMediaParaArquivos(){
		assertEquals(Complexidade.MEDIA, calcula(new ArquivoLogicoInterno(1, 51)));
		assertEquals(Complexidade.MEDIA, calcula(new ArquivoDeInterfaceExterna(1, 55)));
		
		assertEquals(Complexidade.MEDIA, calcula(new ArquivoLogicoInterno(2, 30)));
		assertEquals(Complexidade.MEDIA, calcula(new ArquivoDeInterfaceExterna(3, 21)));
		assertEquals(Complexidade.MEDIA, calcula(new ArquivoLogicoInterno(4, 50)));
		
		assertEquals(Complexidade.MEDIA, calcula(new ArquivoLogicoInterno(7, 19)));
		assertEquals(Complexidade.MEDIA, calcula(new ArquivoDeInterfaceExterna(10, 1)));
	}
	
	@Test
	public void deveRetornarComplexidadeAltaParaArquivos(){
		assertEquals(Complexidade.ALTA, calcula(new ArquivoLogicoInterno(2, 51)));
		assertEquals(Complexidade.ALTA, calcula(new ArquivoDeInterfaceExterna(3, 51)));
		assertEquals(Complexidade.ALTA, calcula(new ArquivoDeInterfaceExterna(5, 60)));
		
		assertEquals(Complexidade.ALTA, calcula(new ArquivoLogicoInterno(5, 60)));
		assertEquals(Complexidade.ALTA, calcula(new ArquivoLogicoInterno(5, 70)));
		
		assertEquals(Complexidade.ALTA, calcula(new ArquivoLogicoInterno(6, 20)));
		assertEquals(Complexidade.ALTA, calcula(new ArquivoLogicoInterno(6, 40)));
		assertEquals(Complexidade.ALTA, calcula(new ArquivoLogicoInterno(8, 60)));
	}
	
	@Test
	public void deveRetornarComplexidadeBaixaParaEntradasExternas(){
		assertEquals(Complexidade.BAIXA, calcula(new EntradaExterna(1, 4)));
		assertEquals(Complexidade.BAIXA, calcula(new EntradaExterna(1, 3)));
		
		assertEquals(Complexidade.BAIXA, calcula(new EntradaExterna(2, 3)));
		
		assertEquals(Complexidade.BAIXA, calcula(new EntradaExterna(1, 13)));
		assertEquals(Complexidade.BAIXA, calcula(new EntradaExterna(1, 15)));
	}
	
	@Test
	public void deveRetornarComplexidadeMediaParaEntradasExternas(){
		assertEquals(Complexidade.MEDIA, calcula(new EntradaExterna(1, 16)));
		
		assertEquals(Complexidade.MEDIA, calcula(new EntradaExterna(2, 5)));
		assertEquals(Complexidade.MEDIA, calcula(new EntradaExterna(2, 15)));
		
		assertEquals(Complexidade.MEDIA, calcula(new EntradaExterna(3, 1)));
		assertEquals(Complexidade.MEDIA, calcula(new EntradaExterna(5, 4)));
	}
	
	@Test
	public void deveRetornarComplexidadeAltaParaEntradasExternas(){
		assertEquals(Complexidade.ALTA, calcula(new EntradaExterna(2, 16)));
		assertEquals(Complexidade.ALTA, calcula(new EntradaExterna(2, 17)));
		
		assertEquals(Complexidade.ALTA, calcula(new EntradaExterna(3, 5)));
		assertEquals(Complexidade.ALTA, calcula(new EntradaExterna(4, 8)));
		assertEquals(Complexidade.ALTA, calcula(new EntradaExterna(3, 16)));
	}
	
	@Test
	public void deveRetornarComplexidadeBaixaParaSaidasEConsultasExternas(){
		assertEquals(Complexidade.BAIXA, calcula(new SaidaExterna(1, 4)));
		assertEquals(Complexidade.BAIXA, calcula(new CosultaExterna(1, 4)));
		assertEquals(Complexidade.BAIXA, calcula(new SaidaExterna(1, 5)));
		assertEquals(Complexidade.BAIXA, calcula(new CosultaExterna(1, 5)));
		assertEquals(Complexidade.BAIXA, calcula(new SaidaExterna(1, 6)));
		assertEquals(Complexidade.BAIXA, calcula(new CosultaExterna(1, 6)));
		assertEquals(Complexidade.BAIXA, calcula(new SaidaExterna(1, 19)));
		assertEquals(Complexidade.BAIXA, calcula(new CosultaExterna(1, 19)));
		
		assertEquals(Complexidade.BAIXA, calcula(new SaidaExterna(2, 5)));
		assertEquals(Complexidade.BAIXA, calcula(new CosultaExterna(2, 4)));
		assertEquals(Complexidade.BAIXA, calcula(new SaidaExterna(3, 5)));
		assertEquals(Complexidade.BAIXA, calcula(new CosultaExterna(3, 4)));
	}
	
	@Test
	public void deveRetornarComplexidadeMediaParaSaidasEConsultasExternas(){
		assertEquals(Complexidade.MEDIA, calcula(new SaidaExterna(1, 20)));
		assertEquals(Complexidade.MEDIA, calcula(new CosultaExterna(1, 21)));
		assertEquals(Complexidade.MEDIA, calcula(new CosultaExterna(1, 21)));
		
		assertEquals(Complexidade.MEDIA, calcula(new SaidaExterna(2, 6)));
		assertEquals(Complexidade.MEDIA, calcula(new SaidaExterna(3, 17)));
		assertEquals(Complexidade.MEDIA, calcula(new CosultaExterna(2, 19)));
		
		assertEquals(Complexidade.MEDIA, calcula(new SaidaExterna(4, 4)));
		assertEquals(Complexidade.MEDIA, calcula(new CosultaExterna(4, 4)));
		assertEquals(Complexidade.MEDIA, calcula(new SaidaExterna(5, 5)));
		assertEquals(Complexidade.MEDIA, calcula(new CosultaExterna(7, 5)));
	}
	
	@Test
	public void deveRetornarComplexidadeAltaParaSaidasEConsultasExternas(){
		assertEquals(Complexidade.ALTA, calcula(new SaidaExterna(2, 20)));
		assertEquals(Complexidade.ALTA, calcula(new SaidaExterna(3, 21)));
		
		assertEquals(Complexidade.ALTA, calcula(new SaidaExterna(4, 6)));
		assertEquals(Complexidade.ALTA, calcula(new CosultaExterna(4, 7)));
		assertEquals(Complexidade.ALTA, calcula(new SaidaExterna(5, 8)));
		assertEquals(Complexidade.ALTA, calcula(new CosultaExterna(7, 19)));
	}

}
