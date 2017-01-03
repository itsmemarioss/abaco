package br.com.mario.abaco.model;

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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.mario.abaco.model.sisp2_2.ProjetoFactory;
import br.com.mario.abaco.model.sisp2_2.TipoContagemSISP;

@Entity
public class Analise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String proposito;
	private String fronteira;
	private String escopo;
	private String responsavel;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="analise_id")
	private Projeto projeto;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
	private TipoContagemSISP tipoDeContagem;
	
	@ManyToOne
	private Sistema sistema;
	
	@Override
	public String toString() {
		return "Analise [tipoDeContagem=" + tipoDeContagem.getDescricao() + ", sistema=" + sistema.getNome() + "]";
	}
	
	public String getDescricao(){
		return "Projeto de "+tipoDeContagem.getDescricao()+" "+sistema.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public TipoContagemSISP getTipoDeContagem() {
		return tipoDeContagem;
	}

	public void setTipoDeContagem(TipoContagemSISP tipoDeContagem) {
		if(projeto == null || tipoDeContagem != this.tipoDeContagem)
			this.projeto = ProjetoFactory.criar(tipoDeContagem);
		
		this.tipoDeContagem = tipoDeContagem;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
