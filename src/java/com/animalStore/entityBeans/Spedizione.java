/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.entityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author salvatore
 */
@Entity
@Table(name = "spedizione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spedizione.findAll", query = "SELECT s FROM Spedizione s"),
    @NamedQuery(name = "Spedizione.findBySpedizioneId", query = "SELECT s FROM Spedizione s WHERE s.spedizioneId = :spedizioneId"),
    @NamedQuery(name = "Spedizione.findByIndirizzo", query = "SELECT s FROM Spedizione s WHERE s.indirizzo = :indirizzo"),
    @NamedQuery(name = "Spedizione.findByCostoSpedizione", query = "SELECT s FROM Spedizione s WHERE s.costoSpedizione = :costoSpedizione")})
public class Spedizione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "spedizione_id")
    private Integer spedizioneId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "indirizzo")
    private String indirizzo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_spedizione")
    private double costoSpedizione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSpedizione")
    private Collection<Ordine> ordineCollection;

    public Spedizione() {
    }

    public Spedizione(Integer spedizioneId) {
        this.spedizioneId = spedizioneId;
    }

    public Spedizione(Integer spedizioneId, String indirizzo, double costoSpedizione) {
        this.spedizioneId = spedizioneId;
        this.indirizzo = indirizzo;
        this.costoSpedizione = costoSpedizione;
    }

    public Integer getSpedizioneId() {
        return spedizioneId;
    }

    public void setSpedizioneId(Integer spedizioneId) {
        this.spedizioneId = spedizioneId;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public double getCostoSpedizione() {
        return costoSpedizione;
    }

    public void setCostoSpedizione(double costoSpedizione) {
        this.costoSpedizione = costoSpedizione;
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
        hash += (spedizioneId != null ? spedizioneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spedizione)) {
            return false;
        }
        Spedizione other = (Spedizione) object;
        if ((this.spedizioneId == null && other.spedizioneId != null) || (this.spedizioneId != null && !this.spedizioneId.equals(other.spedizioneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.animalStore.entityBeans.Spedizione[ spedizioneId=" + spedizioneId + " ]";
    }
    
}
