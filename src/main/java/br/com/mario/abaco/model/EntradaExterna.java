package br.com.mario.abaco.model;

import java.util.HashMap;
import java.util.Map;

public class EntradaExterna extends FuncaoDeTransacao {

	public EntradaExterna(int arquivosReferenciados, int tipoDeDados) {
		super(arquivosReferenciados, tipoDeDados);
	}

	private final Map<Complexidade, Integer> contribuicao;
	
	{
		contribuicao = new HashMap();
		contribuicao.put(Complexidade.BAIXA, 3);
		contribuicao.put(Complexidade.MEDIA, 4);
		contribuicao.put(Complexidade.ALTA,  6);
	}
	
	@Override
	public Complexidade getComplexidade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getContribuicao() {
		// TODO Auto-generated method stub
		return 0;
	}

}
