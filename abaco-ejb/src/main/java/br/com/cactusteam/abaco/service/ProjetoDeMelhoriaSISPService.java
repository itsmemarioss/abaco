package br.com.cactusteam.abaco.service;

import br.com.cactusteam.abaco.core.sisp.ProjetoDeMelhoriaSISP;
import br.com.cactusteam.abaco.dao.ProjetoDeMelhoriaSISPDAO;

import javax.ejb.Stateless;

/**
 * Created by karloskelvin on 11/07/17.
 */
@Stateless
public class ProjetoDeMelhoriaSISPService {

    ProjetoDeMelhoriaSISPDAO dao;

    public void salvar(ProjetoDeMelhoriaSISP projeto){
        dao.salvar(projeto);
    }
}
