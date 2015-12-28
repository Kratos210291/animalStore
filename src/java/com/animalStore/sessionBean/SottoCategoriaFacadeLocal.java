/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.sessionBean;

import com.animalStore.entityBeans.SottoCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author salvatore
 */
@Local
public interface SottoCategoriaFacadeLocal {

    void create(SottoCategoria sottoCategoria);

    void edit(SottoCategoria sottoCategoria);

    void remove(SottoCategoria sottoCategoria);

    SottoCategoria find(Object id);

    List<SottoCategoria> findAll();

    List<SottoCategoria> findRange(int[] range);

    int count();
    
}
