/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.entityBeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author salvatore
 */
@Entity
@Table(name = "utente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u"),
    @NamedQuery(name = "Utente.findByEmail", query = "SELECT u FROM Utente u WHERE u.email = :email"),
    @NamedQuery(name = "Utente.findByNome", query = "SELECT u FROM Utente u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utente.findByCognome", query = "SELECT u FROM Utente u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "Utente.findByIndirizzo", query = "SELECT u FROM Utente u WHERE u.indirizzo = :indirizzo"),
    @NamedQuery(name = "Utente.findByEta", query = "SELECT u FROM Utente u WHERE u.eta = :eta"),
    @NamedQuery(name = "Utente.findByPassword", query = "SELECT u FROM Utente u WHERE u.password = :password"),
    @NamedQuery(name = "Utente.findByRegData", query = "SELECT u FROM Utente u WHERE u.regData = :regData"),
    @NamedQuery(name = "Utente.findByNumeroTel", query = "SELECT u FROM Utente u WHERE u.numeroTel = :numeroTel"),
    @NamedQuery(name = "Utente.findByRuolo", query = "SELECT u FROM Utente u WHERE u.ruolo = :ruolo")})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "cognome")
    private String cognome;
    @Size(max = 45)
    @Column(name = "indirizzo")
    private String indirizzo;
    @Column(name = "eta")
    private Integer eta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reg_data")
    @Temporal(TemporalType.DATE)
    private Date regData;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numeroTel")
    private String numeroTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ruolo")
    private String ruolo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<Ordine> ordineCollection;

    public Utente() {
    }

    public Utente(String email) {
        this.email = email;
    }

    public Utente(String email, String nome, String password, Date regData, String numeroTel, String ruolo) {
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.regData = regData;
        this.numeroTel = numeroTel;
        this.ruolo = ruolo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegData() {
        return regData;
    }

    public void setRegData(Date regData) {
        this.regData = regData;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @XmlTransient
    public Collection<Ordine> getOrdineCollection() {
        return ordineCollection;
    }

    public void setOrdineCollection(Collection<Ordine> ordineCollection) {
        this.ordineCollection = ordineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.animalStore.entityBeans.Utente[ email=" + email + " ]";
    }
    
}
