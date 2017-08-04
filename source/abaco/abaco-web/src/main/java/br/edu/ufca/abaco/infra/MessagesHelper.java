package br.edu.ufca.abaco.infra;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

public class MessagesHelper implements Serializable{

	@Inject
	private FacesContext facesContext;
	
	public void addFlash(FacesMessage message){
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		facesContext.addMessage(null, message);
	}

	public void addMessage(FacesMessage message){
		facesContext.addMessage(null, message);
	}

	public void addMessage(String clientId, FacesMessage message){
		facesContext.addMessage( clientId, message);
	}
}
