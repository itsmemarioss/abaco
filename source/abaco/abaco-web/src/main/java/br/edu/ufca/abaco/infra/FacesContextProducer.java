package br.edu.ufca.abaco.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * Classe para produzir o {@link FacesContext}
 * 
 * Até a versão 2.2, versão atual do JSF, não tem uma integração completa 
 * com o CDI. Alguns componentes, como o FacesContext , ainda não são 
 * gerenciados pelo container de injeção.
 * 
 * @author mario
 *
 */
@ApplicationScoped
public class FacesContextProducer {
	
	@Produces
	@RequestScoped
	public FacesContext get(){
		return FacesContext.getCurrentInstance();
	}

}
