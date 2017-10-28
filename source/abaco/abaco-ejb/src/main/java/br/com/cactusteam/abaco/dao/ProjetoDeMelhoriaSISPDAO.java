package br.com.cactusteam.abaco.dao;

import br.com.cactusteam.abaco.core.sisp.ProjetoDeMelhoriaSISP;

import javax.persistence.EntityManager;

/**
 * Created by karloskelvin on 11/07/17.
 */
public class ProjetoDeMelhoriaSISPDAO extends DAOGenerico<ProjetoDeMelhoriaSISP,Long> {

    public ProjetoDeMelhoriaSISPDAO(EntityManager entityManager) {
        super(ProjetoDeMelhoriaSISP.class, entityManager);
    }
}
