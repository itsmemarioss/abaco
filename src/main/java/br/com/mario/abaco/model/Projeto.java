package br.com.mario.abaco.model;

import java.util.Collections;
import java.util.List;

public abstract class Projeto {

	private Long id;
	private List<Contagem> contagens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Contagem> getContagens() {
		return Collections.unmodifiableList(contagens);
	}

	public void addContagem(Contagem contagem){
		contagens.add(contagem);
	}

	public abstract void encerrarContagem();

}
