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
@Table(name = "prodotto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodotto.findAll", query = "SELECT p FROM Prodotto p"),
    @NamedQuery(name = "Prodotto.findByProdId", query = "SELECT p FROM Prodotto p WHERE p.prodId = :prodId"),
    @NamedQuery(name = "Prodotto.findByProdName", query = "SELECT p FROM Prodotto p WHERE p.prodName = :prodName"),
    @NamedQuery(name = "Prodotto.findByProdQta", query = "SELECT p FROM Prodotto p WHERE p.prodQta = :prodQta"),
    @NamedQuery(name = "Prodotto.findByProdPrezzo", query = "SELECT p FROM Prodotto p WHERE p.prodPrezzo = :prodPrezzo"),
    @NamedQuery(name = "Prodotto.findByProdUrl", query = "SELECT p FROM Prodotto p WHERE p.prodUrl = :prodUrl"),
    @NamedQuery(name = "Prodotto.findByProdDescr", query = "SELECT p FROM Prodotto p WHERE p.prodDescr = :prodDescr")})
public class Prodotto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_id")
    private Integer prodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prod_name")
    private String prodName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_qta")
    private int prodQta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_prezzo")
    private double prodPrezzo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prod_url")
    private String prodUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "prod_descr")
    private String prodDescr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private Collection<Ordine> ordineCollection;
    @JoinColumn(name = "sotto_cat_id", referencedColumnName = "sotto_cat_id")
    @ManyToOne(optional = false)
    private SottoCategoria sottoCatId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<DettaglioOrdine> dettaglioOrdineCollection;

    public Prodotto() {
    }

    public Prodotto(Integer prodId) {
        this.prodId = prodId;
    }

    public Prodotto(Integer prodId, String prodName, int prodQta, double prodPrezzo, String prodUrl, String prodDescr) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodQta = prodQta;
        this.prodPrezzo = prodPrezzo;
        this.prodUrl = prodUrl;
        this.prodDescr = prodDescr;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdQta() {
        return prodQta;
    }

    public void setProdQta(int prodQta) {
        this.prodQta = prodQta;
    }

    public double getProdPrezzo() {
        return prodPrezzo;
    }

    public void setProdPrezzo(double prodPrezzo) {
        this.prodPrezzo = prodPrezzo;
    }

    public String getProdUrl() {
        return prodUrl;
    }

    public void setProdUrl(String prodUrl) {
        this.prodUrl = prodUrl;
    }

    public String getProdDescr() {
        return prodDescr;
    }

    public void setProdDescr(String prodDescr) {
        this.prodDescr = prodDescr;
    }

    @XmlTransient
    public Collection<Ordine> getOrdineCollection() {
        return ordineCollection;
    }

    public void setOrdineCollection(Collection<Ordine> ordineCollection) {
        this.ordineCollection = ordineCollection;
    }

    public SottoCategoria getSottoCatId() {
        return sottoCatId;
    }

    public void setSottoCatId(SottoCategoria sottoCatId) {
        this.sottoCatId = sottoCatId;
    }

    @XmlTransient
    public Collection<DettaglioOrdine> getDettaglioOrdineCollection() {
        return dettaglioOrdineCollection;
    }

    public void setDettaglioOrdineCollection(Collection<DettaglioOrdine> dettaglioOrdineCollection) {
        this.dettaglioOrdineCollection = dettaglioOrdineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodotto)) {
            return false;
        }
        Prodotto other = (Prodotto) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.animalStore.entityBeans.Prodotto[ prodId=" + prodId + " ]";
    }
    
}
