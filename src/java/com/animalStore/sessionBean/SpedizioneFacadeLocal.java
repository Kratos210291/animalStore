/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.sessionBean;

import com.animalStore.entityBeans.Spedizione;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author salvatore
 */
@Local
public interface SpedizioneFacadeLocal {

    void create(Spedizione spedizione);

    void edit(Spedizione spedizione);

    void remove(Spedizione spedizione);

    Spedizione find(Object id);

    List<Spedizione> findAll();

    List<Spedizione> findRange(int[] range);

    int count();
    
}
