package br.com.cactusteam.abaco.controller;

import br.com.cactusteam.abaco.core.DetalheAnalise;
import br.com.cactusteam.abaco.core.sisp.ProjetoDeMelhoriaSISP;
import br.com.cactusteam.abaco.service.ProjetoDeMelhoriaSISPService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by karloskelvin on 11/07/17.
 */

@Named
@ViewScoped
public class ProjetoDeMelhoriaSISPBean implements Serializable{

    @Inject
    ProjetoDeMelhoriaSISPService service;

    private DetalheAnalise detalheAnalise;
    private ProjetoDeMelhoriaSISP projeto;

    @PostConstruct
    public void setup(){
        detalheAnalise = new DetalheAnalise();
        projeto = new ProjetoDeMelhoriaSISP(detalheAnalise);
    }

    public DetalheAnalise getDetalheAnalise() {
        return detalheAnalise;
    }

    public ProjetoDeMelhoriaSISP getProjetoDeMelhoriaSISP() {
        return projeto;
    }
}
