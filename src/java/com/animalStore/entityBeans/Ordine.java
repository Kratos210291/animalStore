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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ordine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordine.findAll", query = "SELECT o FROM Ordine o"),
    @NamedQuery(name = "Ordine.findByOrdId", query = "SELECT o FROM Ordine o WHERE o.ordId = :ordId"),
    @NamedQuery(name = "Ordine.findByOrdData", query = "SELECT o FROM Ordine o WHERE o.ordData = :ordData"),
    @NamedQuery(name = "Ordine.findByOrdQta", query = "SELECT o FROM Ordine o WHERE o.ordQta = :ordQta"),
    @NamedQuery(name = "Ordine.findByPrzTot", query = "SELECT o FROM Ordine o WHERE o.przTot = :przTot"),
    @NamedQuery(name = "Ordine.findByOrdStato", query = "SELECT o FROM Ordine o WHERE o.ordStato = :ordStato")})
public class Ordine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_id")
    private Integer ordId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_data")
    @Temporal(TemporalType.DATE)
    private Date ordData;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_qta")
    private int ordQta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prz_tot")
    private double przTot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ord_stato")
    private String ordStato;
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Utente userEmail;
    @JoinColumn(name = "id_spedizione", referencedColumnName = "spedizione_id")
    @ManyToOne(optional = false)
    private Spedizione idSpedizione;
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false)
    private Prodotto prodId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordId")
    private Collection<DettaglioOrdine> dettaglioOrdineCollection;

    public Ordine() {
    }

    public Ordine(Integer ordId) {
        this.ordId = ordId;
    }

    public Ordine(Integer ordId, Date ordData, int ordQta, double przTot, String ordStato) {
        this.ordId = ordId;
        this.ordData = ordData;
        this.ordQta = ordQta;
        this.przTot = przTot;
        this.ordStato = ordStato;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Date getOrdData() {
        return ordData;
    }

    public void setOrdData(Date ordData) {
        this.ordData = ordData;
    }

    public int getOrdQta() {
        return ordQta;
    }

    public void setOrdQta(int ordQta) {
        this.ordQta = ordQta;
    }

    public double getPrzTot() {
        return przTot;
    }

    public void setPrzTot(double przTot) {
        this.przTot = przTot;
    }

    public String getOrdStato() {
        return ordStato;
    }

    public void setOrdStato(String ordStato) {
        this.ordStato = ordStato;
    }

    public Utente getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Utente userEmail) {
        this.userEmail = userEmail;
    }

    public Spedizione getIdSpedizione() {
        return idSpedizione;
    }

    public void setIdSpedizione(Spedizione idSpedizione) {
        this.idSpedizione = idSpedizione;
    }

    public Prodotto getProdId() {
        return prodId;
    }

    public void setProdId(Prodotto prodId) {
        this.prodId = prodId;
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
        hash += (ordId != null ? ordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordine)) {
            return false;
        }
        Ordine other = (Ordine) object;
        if ((this.ordId == null && other.ordId != null) || (this.ordId != null && !this.ordId.equals(other.ordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.animalStore.entityBeans.Ordine[ ordId=" + ordId + " ]";
    }
    
}
