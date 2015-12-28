/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.animalStore.entityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salvatore
 */
@Entity
@Table(name = "dettaglio_ordine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DettaglioOrdine.findAll", query = "SELECT d FROM DettaglioOrdine d"),
    @NamedQuery(name = "DettaglioOrdine.findByDettOrdineId", query = "SELECT d FROM DettaglioOrdine d WHERE d.dettOrdineId = :dettOrdineId"),
    @NamedQuery(name = "DettaglioOrdine.findByProdQta", query = "SELECT d FROM DettaglioOrdine d WHERE d.prodQta = :prodQta")})
public class DettaglioOrdine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dett_ordine_id")
    private Integer dettOrdineId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_qta")
    private int prodQta;
    @JoinColumn(name = "ord_id", referencedColumnName = "ord_id")
    @ManyToOne(optional = false)
    private Ordine ordId;
    @JoinColumn(name = "pro_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false)
    private Prodotto proId;

    public DettaglioOrdine() {
    }

    public DettaglioOrdine(Integer dettOrdineId) {
        this.dettOrdineId = dettOrdineId;
    }

    public DettaglioOrdine(Integer dettOrdineId, int prodQta) {
        this.dettOrdineId = dettOrdineId;
        this.prodQta = prodQta;
    }

    public Integer getDettOrdineId() {
        return dettOrdineId;
    }

    public void setDettOrdineId(Integer dettOrdineId) {
        this.dettOrdineId = dettOrdineId;
    }

    public int getProdQta() {
        return prodQta;
    }

    public void setProdQta(int prodQta) {
        this.prodQta = prodQta;
    }

    public Ordine getOrdId() {
        return ordId;
    }

    public void setOrdId(Ordine ordId) {
        this.ordId = ordId;
    }

    public Prodotto getProId() {
        return proId;
    }

    public void setProId(Prodotto proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dettOrdineId != null ? dettOrdineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DettaglioOrdine)) {
            return false;
        }
        DettaglioOrdine other = (DettaglioOrdine) object;
        if ((this.dettOrdineId == null && other.dettOrdineId != null) || (this.dettOrdineId != null && !this.dettOrdineId.equals(other.dettOrdineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.animalStore.entityBeans.DettaglioOrdine[ dettOrdineId=" + dettOrdineId + " ]";
    }
    
}
