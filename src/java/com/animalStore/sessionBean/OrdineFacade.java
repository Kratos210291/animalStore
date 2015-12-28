/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.sessionBean;

import com.animalStore.entityBeans.Ordine;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author salvatore
 */
@Stateless
public class OrdineFacade extends AbstractFacade<Ordine> implements OrdineFacadeLocal {

    @PersistenceContext(unitName = "AnimalStoreProgettoPSWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdineFacade() {
        super(Ordine.class);
    }
    
}
