package br.com.mario.abaco.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Instituicao {
	
	@Id
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy="instituicao")
	private List<Sistema> sistemas;

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

	public List<Sistema> getSistemas() {
		return sistemas;
	}

	public void setSistemas(List<Sistema> sistemas) {
		this.sistemas = sistemas;
	}

	public void addSistema(Sistema sistema) {
		if(sistemas==null)sistemas = new ArrayList<>();
		sistema.setInstituicao(this);
		sistemas.add(sistema);
	}

}
