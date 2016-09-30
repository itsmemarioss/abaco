package br.com.mario.abaco.model;

import java.util.HashMap;
import java.util.Map;

public class ArquivoDeInterfaceExterna extends FuncaoDeDado {

	private final Map<Complexidade, Integer> contribuicao;
	
	{
		contribuicao = new HashMap();
		contribuicao.put(Complexidade.BAIXA, 5);
		contribuicao.put(Complexidade.MEDIA, 7);
		contribuicao.put(Complexidade.ALTA, 10);
	}
	
	public ArquivoDeInterfaceExterna(int tipoDeRegistros, int tipoDeDados) {
		super(tipoDeRegistros, tipoDeDados);
	}

	@Override
	public int getContribuicao() {
		return contribuicao.get(getComplexidade());
	}

}
