package br.com.mario.abaco.model;

public class CalculaComplexidade {

	public static Complexidade calcula(FuncaoDeDado funcao) {
		int tipoDeDados = funcao.getTipoDeDados();
		int tipoDeRegistros = funcao.getTipoDeRegistros();
		
		Complexidade complexidade = null;
		
		if (tipoDeRegistros<=0)throw new IllegalArgumentException("O valo do tipo de dados deve ser maior que zero");
		
		if (tipoDeRegistros == 1){
			if(tipoDeDados<=50){
				complexidade = Complexidade.BAIXA;
			}else{
				complexidade = Complexidade.MEDIA;
			}
		}else if (tipoDeRegistros <= 5){
			if(tipoDeDados<20){
				complexidade = Complexidade.BAIXA;
			}else if(tipoDeDados<=50){
				complexidade = Complexidade.MEDIA;
			}else{
				complexidade = Complexidade.ALTA;
			}
		}else{
			if(tipoDeDados<20){
				complexidade = Complexidade.MEDIA;
			}else{
				complexidade = Complexidade.ALTA;
			}
		}
		
		return complexidade;
	}
	
	public static Complexidade calcula (FuncaoDeTransacao funcao){
		Complexidade complexidade = null;
		
		if(funcao instanceof EntradaExterna)
			complexidade = calculaParaEntradaExterna(funcao);
		else
			complexidade = calculaParaConsultaESaidaExterna(funcao);
		
		return complexidade;
	}

	private static Complexidade calculaParaConsultaESaidaExterna(FuncaoDeTransacao funcao) {
		return Complexidade.BAIXA;
	}

	private static Complexidade calculaParaEntradaExterna(FuncaoDeTransacao funcao) {
		int tipoDeDados = funcao.getTipoDeDados();
		int arquivosReferenciados = funcao.getArquivosReferenciados();
		
		Complexidade complexidade = null;
		
		if(arquivosReferenciados<2){
			if (tipoDeDados<=15) 
				complexidade = Complexidade.BAIXA;
			else
				complexidade = Complexidade.MEDIA;
			
		}else if (arquivosReferenciados == 2){
			if(tipoDeDados<5) 
				complexidade = Complexidade.BAIXA;
			else if(tipoDeDados>=5 && tipoDeDados <=15)
				complexidade = Complexidade.MEDIA;
			else 
				complexidade = Complexidade.ALTA;
		}else{
			if(tipoDeDados<5) 
				complexidade = Complexidade.MEDIA;
			else
				complexidade = Complexidade.ALTA;
		}
		return complexidade;
	}

}
