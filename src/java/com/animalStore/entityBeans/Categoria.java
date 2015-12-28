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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCatId", query = "SELECT c FROM Categoria c WHERE c.catId = :catId"),
    @NamedQuery(name = "Categoria.findByCatNome", query = "SELECT c FROM Categoria c WHERE c.catNome = :catNome"),
    @NamedQuery(name = "Categoria.findByCatDescrizione", query = "SELECT c FROM Categoria c WHERE c.catDescrizione = :catDescrizione")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer catId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cat_nome")
    private String catNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cat_descrizione")
    private String catDescrizione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private Collection<SottoCategoria> sottoCategoriaCollection;

    public Categoria() {
    }

    public Categoria(Integer catId) {
        this.catId = catId;
    }

    public Categoria(Integer catId, String catNome, String catDescrizione) {
        this.catId = catId;
        this.catNome = catNome;
        this.catDescrizione = catDescrizione;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatNome() {
        return catNome;
    }

    public void setCatNome(String catNome) {
        this.catNome = catNome;
    }

    public String getCatDescrizione() {
        return catDescrizione;
    }

    public void setCatDescrizione(String catDescrizione) {
        this.catDescrizione = catDescrizione;
    }

    @XmlTransient
    public Collection<SottoCategoria> getSottoCategoriaCollection() {
        return sottoCategoriaCollection;
    }

    public void setSottoCategoriaCollection(Collection<SottoCategoria> sottoCategoriaCollection) {
        this.sottoCategoriaCollection = sottoCategoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.animalStore.entityBeans.Categoria[ catId=" + catId + " ]";
    }
    
}
