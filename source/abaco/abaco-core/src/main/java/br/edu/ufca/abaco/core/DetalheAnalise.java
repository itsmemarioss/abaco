package br.edu.ufca.abaco.core;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.ufca.abaco.core.dao.BaseEntity;

@Entity(name="detalhe_analise")
public class DetalheAnalise implements BaseEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String proposito;
	private String fronteira;
	private String escopo;
	private LocalDate data;
	
	public DetalheAnalise() {
		data = LocalDate.now();
	}
	
	public DetalheAnalise(Builder builder){
		proposito = builder.proposito;
		fronteira = builder.fronteira;
		escopo = builder.escopo;
		data = builder.data;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	public String getFronteira() {
		return fronteira;
	}

	public void setFronteira(String fronteira) {
		this.fronteira = fronteira;
	}

	public String getEscopo() {
		return escopo;
	}

	public void setEscopo(String escopo) {
		this.escopo = escopo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public static class Builder{
		private String proposito;
		private String fronteira;
		private String escopo;
		private LocalDate data;
		
		public Builder proposito(String proposito){
			this.proposito = proposito; 
			return this;
		}
		
		public Builder fronteira(String fronteira){
			this.fronteira = fronteira; 
			return this;
		}
		
		public Builder escopo(String escopo){
			this.escopo = escopo; 
			return this;
		}
		
		public Builder data(LocalDate data){
			this.data = data; 
			return this;
		}
		
		public DetalheAnalise build(){
			return new DetalheAnalise(this);
		}
		
	}
		
}
