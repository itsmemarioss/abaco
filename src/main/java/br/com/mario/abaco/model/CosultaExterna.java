package br.com.mario.abaco.model;

import java.util.HashMap;
import java.util.Map;

public class CosultaExterna extends FuncaoDeTransacao{

	public CosultaExterna(int arquivosReferenciados, int tipoDeDados) {
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
	public int getContribuicao() {
		return contribuicao.get(getComplexidade());
	}

}
