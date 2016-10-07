package br.com.mario.abaco.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Configuracao {
	
	@Id
	private Long id;
	
	private String versaoManualSISP;
	private String CPM;
	private String instituicao;
	private String email;
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVersaoManualSISP() {
		return versaoManualSISP;
	}
	public void setVersaoManualSISP(String versaoManualSISP) {
		this.versaoManualSISP = versaoManualSISP;
	}
	public String getCPM() {
		return CPM;
	}
	public void setCPM(String cPM) {
		CPM = cPM;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
