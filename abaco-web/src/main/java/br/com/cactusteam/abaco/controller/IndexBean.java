package br.com.cactusteam.abaco.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.cactusteam.abaco.infra.MessagesHelper;

@Model
public class IndexBean {
	
	@Inject
	private MessagesHelper helper;
	
	private String NEW_PAGE = "/index.xhtml?faces-redirect=true";
	
	@PostConstruct
	public void setup(){
		
	}
	
	public String novo(){
		setup();
		return NEW_PAGE;
	}
	
	public String getText(){
		return "You are on index page";
	}
	
	
}
