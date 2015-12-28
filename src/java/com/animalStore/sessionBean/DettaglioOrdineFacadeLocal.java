/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.sessionBean;

import com.animalStore.entityBeans.DettaglioOrdine;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author salvatore
 */
@Local
public interface DettaglioOrdineFacadeLocal {

    void create(DettaglioOrdine dettaglioOrdine);

    void edit(DettaglioOrdine dettaglioOrdine);

    void remove(DettaglioOrdine dettaglioOrdine);

    DettaglioOrdine find(Object id);

    List<DettaglioOrdine> findAll();

    List<DettaglioOrdine> findRange(int[] range);

    int count();
    
}
