package br.edu.ufca.abaco.service;

import br.edu.ufca.abaco.core.sisp.ProjetoDeMelhoriaSISP;
import br.edu.ufca.abaco.dao.ProjetoDeMelhoriaSISPDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
