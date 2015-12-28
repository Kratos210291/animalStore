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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sottoCategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SottoCategoria.findAll", query = "SELECT s FROM SottoCategoria s"),
    @NamedQuery(name = "SottoCategoria.findBySottoCatId", query = "SELECT s FROM SottoCategoria s WHERE s.sottoCatId = :sottoCatId"),
    @NamedQuery(name = "SottoCategoria.findBySottoCatNome", query = "SELECT s FROM SottoCategoria s WHERE s.sottoCatNome = :sottoCatNome"),
    @NamedQuery(name = "SottoCategoria.findBySottoCatDescrizione", query = "SELECT s FROM SottoCategoria s WHERE s.sottoCatDescrizione = :sottoCatDescrizione")})
public class SottoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sotto_cat_id")
    private Integer sottoCatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sotto_cat_nome")
    private String sottoCatNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "sotto_cat_descrizione")
    private String sottoCatDescrizione;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Categoria catId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sottoCatId")
    private Collection<Prodotto> prodottoCollection;

    public SottoCategoria() {
    }

    public SottoCategoria(Integer sottoCatId) {
        this.sottoCatId = sottoCatId;
    }

    public SottoCategoria(Integer sottoCatId, String sottoCatNome, String sottoCatDescrizione) {
        this.sottoCatId = sottoCatId;
        this.sottoCatNome = sottoCatNome;
        this.sottoCatDescrizione = sottoCatDescrizione;
    }

    public Integer getSottoCatId() {
        return sottoCatId;
    }

    public void setSottoCatId(Integer sottoCatId) {
        this.sottoCatId = sottoCatId;
    }

    public String getSottoCatNome() {
        return sottoCatNome;
    }

    public void setSottoCatNome(String sottoCatNome) {
        this.sottoCatNome = sottoCatNome;
    }

    public String getSottoCatDescrizione() {
        return sottoCatDescrizione;
    }

    public void setSottoCatDescrizione(String sottoCatDescrizione) {
        this.sottoCatDescrizione = sottoCatDescrizione;
    }

    public Categoria getCatId() {
        return catId;
    }

    public void setCatId(Categoria catId) {
        this.catId = catId;
    }

    @XmlTransient
    public Collection<Prodotto> getProdottoCollection() {
        return prodottoCollection;
    }

    public void setProdottoCollection(Collection<Prodotto> prodottoCollection) {
        this.prodottoCollection = prodottoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sottoCatId != null ? sottoCatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SottoCategoria)) {
            return false;
        }
        SottoCategoria other = (SottoCategoria) object;
        if ((this.sottoCatId == null && other.sottoCatId != null) || (this.sottoCatId != null && !this.sottoCatId.equals(other.sottoCatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.animalStore.entityBeans.SottoCategoria[ sottoCatId=" + sottoCatId + " ]";
    }
    
}
