package br.edu.ufca.abaco.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ufca.abaco.core.DetalheAnalise;
import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.FuncaoDeTransacao;
import br.edu.ufca.abaco.core.sisp.ProjetoDeMigracaoSISP;
import br.edu.ufca.abaco.infra.MessagesHelper;
import br.edu.ufca.abaco.service.ProjetoDeMigracaoSISPService;

@Named
@ViewScoped
public class ProjetoDeMigracaoSISPBean implements Serializable {

	@Inject
	private ProjetoDeMigracaoSISPService service;

	@Inject
	private MessagesHelper messagesHelper;
	
	private DetalheAnalise detalhe;
	private ProjetoDeMigracaoSISP projetoDeMigracaoSISP;

	private FuncaoDeDado funcaoDeDado;
	private FuncaoDeTransacao funcaoDeTransacao;
	
	@PostConstruct
	public void setup(){
		detalhe = new DetalheAnalise();
		projetoDeMigracaoSISP = new ProjetoDeMigracaoSISP(detalhe);
	}

	public DetalheAnalise getDetalhe() {
		return detalhe;
	}

	public ProjetoDeMigracaoSISP getProjetoDeMigracaoSISP() {
		return projetoDeMigracaoSISP;
	}
	
	public FuncaoDeTransacao getFuncaoDeTransacao(){return funcaoDeTransacao;}
	public FuncaoDeDado getFuncaoDeDado(){return funcaoDeDado;}

	public void addFuncaoDeDado(){
		projetoDeMigracaoSISP.incluiFuncaoDeDado(funcaoDeDado);
	}
	public void addFuncaoDeTransacao(){
		projetoDeMigracaoSISP.incluiFuncaoDeTransacao(funcaoDeTransacao);
	}

	public void novoALI(){
		funcaoDeDado = FuncaoDeDado.novoArquivoLogicoInterno();
	}

	public void novoAIE(){
		funcaoDeDado = FuncaoDeDado.novoArquivoDeInterfaceExterna();
	}

	/**
	 * salva a contagem como rascunho e prossegue
	 */
	@Transactional
	public void salvarEContinuar(){
		service.salvarOuAtualizar(projetoDeMigracaoSISP);
	}

	@Transactional
	public void salvar(){
		salvarEContinuar();
		messagesHelper.addFlash(new FacesMessage("Info: ", "Dados salvos com sucesso"));
	}
}
