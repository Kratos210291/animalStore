/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.controller;

import com.animalStore.entityBeans.Utente;
import com.animalStore.sessionBean.UtenteFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author salvatore
 */
@ManagedBean
@SessionScoped
public class registrazioneController implements Serializable {

    @EJB
    private UtenteFacadeLocal utenteFacade;
    private Utente utente;

    public registrazioneController() {
    }

    public String preparaRegistrazione() {
        this.utente = new Utente();
        return "registrazione";
    }

    public UtenteFacadeLocal getUtenteFacade() {
        return utenteFacade;
    }

    public void setUtenteFacade(UtenteFacadeLocal utenteFacade) {
        this.utenteFacade = utenteFacade;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String registra() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            Date date = new Date();
            this.utente.setRegData(date);
            this.utente.setRuolo("Utente");
            this.utenteFacade.create(utente);
            return "index";
        } catch (EJBException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email già presente", "Email già presente");

            facesContext.addMessage(null, message);
        }
        return null;
    }

}
