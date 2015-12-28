/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.controller;

import com.animalStore.entityBeans.Utente;
import com.animalStore.sessionBean.UtenteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author salvatore
 */
@ManagedBean
@SessionScoped
public class loginController {
    @EJB
    private UtenteFacadeLocal utenteFacade;
    private String email;
    private String password;

    public loginController() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String login(){
        List<Utente> listaUtenti=this.utenteFacade.findAll();
        for(Utente u:listaUtenti){
            if(this.password.equals(u.getPassword())&&this.email.equals(u.getEmail())&&u.getRuolo().equals("Admin")){
                return "/amministrazione/homeAdmin";
            }
        }
        return null;
    }
    public String logout(){
        return "index";
    }
}
