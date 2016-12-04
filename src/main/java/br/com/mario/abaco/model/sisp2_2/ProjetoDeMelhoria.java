package br.com.mario.abaco.model.sisp2_2;

import javax.persistence.Entity;

import br.com.mario.abaco.model.Contagem;
import br.com.mario.abaco.model.Projeto;

@Entity
public class ProjetoDeMelhoria extends Projeto{

	public enum FatorDeImpacto{
		CINQUENTA("50%",0.5),
		SETENTA_E_CINCO("75%",0.75),
		NOVENTA("90%",0.9);
		
		private String descricao; private double valor;

		private FatorDeImpacto(String descricao, double valor) {
			this.descricao = descricao;
			this.valor = valor;
		}

		public String getDescricao() {
			return descricao;
		}

		public double getValor() {
			return valor;
		}

	}
	
	public ProjetoDeMelhoria() {
		getContagens().add(new Contagem("PF Incluídos"));
		getContagens().add(new Contagem("PF Alterados"));
		getContagens().add(new Contagem("PF Excluídos",0.3));
		getContagens().add(new Contagem("PF de Conversão",true));
	}

}
