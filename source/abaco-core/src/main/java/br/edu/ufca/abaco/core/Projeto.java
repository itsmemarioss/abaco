package br.edu.ufca.abaco.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.swing.plaf.synth.SynthSeparatorUI;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Projeto {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="projeto_id")
	private List<Contagem> contagens;
	
	public Projeto() {
		super();
		contagens = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Contagem> getContagens() {
		return contagens;
	}

	public void addContagem(Contagem contagem){
		contagens.add(contagem);
	}
	
	public void addFuncaoDeDado(int idLista, FuncaoDeDado funcao){
		System.out.println(idLista+"-"+funcao);
		
		getContagens().get(idLista).addFuncaoDeDado(funcao);
	}
	
	public void addFuncaoDeTransacao(int idLista, FuncaoDeTransacao funcao){
		getContagens().get(idLista).addFuncaoDeTransacao(funcao);
	}

	public double total() {
		return getContagens().stream()
				.mapToDouble(Contagem::total)
				.sum();
	}

}
