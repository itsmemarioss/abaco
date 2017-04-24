package br.edu.ufca.abaco.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sistema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String nome;
	
	private String descricao;
	
	private String tecnologias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTecnologias() {
		return tecnologias;
	}
	
	/**
	 * Nome das tecnologias utilizadas no sistema separadas por vírgula
	 * @param tecnologias
	 */
	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}

}
