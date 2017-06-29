package br.edu.ufca.abaco.infra;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessagesHelper {

	@Inject
	private FacesContext facesContext;
	
	public void addFlash(FacesMessage message){
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		facesContext.addMessage(null, message);
	}
}
