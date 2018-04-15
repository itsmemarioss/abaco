package br.com.cactusteam.abaco.core;

public class CalculadoraDeContribuicao {
	
	private CalculadoraDeContribuicao() {}

	public static int calcula(Funcao funcao){
		if(funcao instanceof FuncaoDeDado){
			return calculaFuncaoDado((FuncaoDeDado) funcao);
		}else{
			return calculaFuncaoTransacao((FuncaoDeTransacao) funcao);
		}
	}

	public static int calculaFuncaoTransacao(FuncaoDeTransacao funcao) {
		int contribuicao = 0;
		if (funcao.getTipo().equals(TipoFuncaoTransacao.SE)) {
			switch (funcao.getComplexidade()) {
			case BAIXA:
				contribuicao = 4;
				break;
			case MEDIA:
				contribuicao = 5;
				break;
			default:
				contribuicao = 7;
				break;
			}
		} else {
			switch (funcao.getComplexidade()) {
			case BAIXA:
				contribuicao = 3;
				break;
			case MEDIA:
				contribuicao = 4;
				break;
			default:
				contribuicao = 6;
				break;
			}
		}
		return contribuicao;
	}

	public static int calculaFuncaoDado(FuncaoDeDado funcao) {
		int contribuicao = 0;
		if (funcao.getTipo().equals(TipoFuncaoDado.ALI)) {
			switch (funcao.getComplexidade()) {
			case BAIXA:
				contribuicao = 7;
				break;
			case MEDIA:
				contribuicao = 10;
				break;
			default:
				contribuicao = 15;
				break;
			}
		}else{//AIE
			switch (funcao.getComplexidade()) {
			case BAIXA:
				contribuicao = 5;
				break;
			case MEDIA:
				contribuicao = 7;
				break;
			default:
				contribuicao = 10;
				break;
			}
		}
		return contribuicao;
	}

}
