package br.edu.ufca.abaco.core;

public class CalculadoraDeComplexidade {

	private CalculadoraDeComplexidade() {}

	public static Complexidade calcula(FuncaoDeDado funcao) {
		int tiposDeDados = funcao.getTiposDeDados();
		int tiposDeRegistros = funcao.getTiposDeRegistros();
		
		Complexidade complexidade = Complexidade.BAIXA;
		
		if (tiposDeRegistros<=0)throw new IllegalArgumentException("O valo do tipo de dados deve ser maior que zero");
		
		if (tiposDeRegistros == 1){
			if(tiposDeDados>50){
				complexidade = Complexidade.MEDIA;
			}
		}else if (tiposDeRegistros <= 5){
			if(tiposDeDados >20 && tiposDeDados<=50){
				complexidade = Complexidade.MEDIA;
			}else if(tiposDeDados>50){
				complexidade = Complexidade.ALTA;
			}
		}else{
			if(tiposDeDados<20){
				complexidade = Complexidade.MEDIA;
			}else{
				complexidade = Complexidade.ALTA;
			}
		}
		
		return complexidade;
	}
	
	public static Complexidade calcula (FuncaoDeTransacao funcao){
		Complexidade complexidade = null;
		
		if(funcao.getTipo().equals(TipoFuncaoTransacao.EE))
			complexidade = calculaParaEntradaExterna(funcao);
		else
			complexidade = calculaParaConsultaESaidaExterna(funcao);
		
		return complexidade;
	}

	private static Complexidade calculaParaConsultaESaidaExterna(FuncaoDeTransacao funcao) {
		int tipoDeDados = funcao.getTiposDeDados();
		int arquivosReferenciados = funcao.getArquivosReferenciados();
		
		Complexidade complexidade = Complexidade.BAIXA;
		
		if(arquivosReferenciados<2){
			
			if(tipoDeDados>19)
				complexidade = Complexidade.MEDIA;
			
		}else if (arquivosReferenciados<=3){
			
			if (tipoDeDados>=6 && tipoDeDados<=19)
				complexidade = Complexidade.MEDIA;
			else if(tipoDeDados>19) 
				complexidade = Complexidade.ALTA;
			
		}else{
			
			if (tipoDeDados<6) 
				complexidade = Complexidade.MEDIA;
			else
				complexidade = Complexidade.ALTA;
			
		}
		
		return complexidade;
	}

	private static Complexidade calculaParaEntradaExterna(FuncaoDeTransacao funcao) {
		int tipoDeDados = funcao.getTiposDeDados();
		int arquivosReferenciados = funcao.getArquivosReferenciados();
		
		Complexidade complexidade = Complexidade.BAIXA;
		
		if(arquivosReferenciados<2){
			if (tipoDeDados>15)
				complexidade = Complexidade.MEDIA;
			
		}else if (arquivosReferenciados == 2){
			if(tipoDeDados>=5 && tipoDeDados <=15)
				complexidade = Complexidade.MEDIA;
			else if(tipoDeDados>15)
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
