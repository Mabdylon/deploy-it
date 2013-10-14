/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.deployIt.concept;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mabdylon
 */
@Entity
@Table(name = "carto_dossier")
@NamedQueries({
    @NamedQuery(name = "CartoDossier.findAll", query = "SELECT c FROM CartoDossier c")})
public class CartoDossier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "tickerRefPartenaire")
    private String tickerRefPartenaire;
    @Column(name = "ticketRefDo")
    private String ticketRefDo;
    @Column(name = "ticketDateOuverture")
    @Temporal(TemporalType.DATE)
    private Date ticketDateOuverture;
    @Column(name = "ticketDateMissionnement")
    @Temporal(TemporalType.DATE)
    private Date ticketDateMissionnement;
    @Column(name = "interventionDate")
    @Temporal(TemporalType.DATE)
    private Date interventionDate;
    @Column(name = "ticketConformite")
    @Temporal(TemporalType.DATE)
    private Date ticketConformite;
    @Column(name = "produitRef")
    private String produitRef;
    @Column(name = "produitFournisseur")
    private String produitFournisseur;
    @Column(name = "marqueProduit")
    private String marqueProduit;
    @Column(name = "produitNom")
    private String produitNom;
    @Column(name = "clientVoie")
    private String clientVoie;
    @Column(name = "clientCp")
    private String clientCp;
    @Column(name = "clientVille")
    private String clientVille;
    @Column(name = "clientTelMobile")
    private String clientTelMobile;
    @Column(name = "clientEmail")
    private String clientEmail;
    @Column(name = "clientNom")
    private String clientNom;

    public CartoDossier() {
    }

    public CartoDossier(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTickerRefPartenaire() {
        return tickerRefPartenaire;
    }

    public void setTickerRefPartenaire(String tickerRefPartenaire) {
        this.tickerRefPartenaire = tickerRefPartenaire;
    }

    public String getTicketRefDo() {
        return ticketRefDo;
    }

    public void setTicketRefDo(String ticketRefDo) {
        this.ticketRefDo = ticketRefDo;
    }

    public Date getTicketDateOuverture() {
        return ticketDateOuverture;
    }

    public void setTicketDateOuverture(Date ticketDateOuverture) {
        this.ticketDateOuverture = ticketDateOuverture;
    }

    public Date getTicketDateMissionnement() {
        return ticketDateMissionnement;
    }

    public void setTicketDateMissionnement(Date ticketDateMissionnement) {
        this.ticketDateMissionnement = ticketDateMissionnement;
    }

    public Date getInterventionDate() {
        return interventionDate;
    }

    public void setInterventionDate(Date interventionDate) {
        this.interventionDate = interventionDate;
    }

    public Date getTicketConformite() {
        return ticketConformite;
    }

    public void setTicketConformite(Date ticketConformite) {
        this.ticketConformite = ticketConformite;
    }

    public String getProduitRef() {
        return produitRef;
    }

    public void setProduitRef(String produitRef) {
        this.produitRef = produitRef;
    }

    public String getProduitFournisseur() {
        return produitFournisseur;
    }

    public void setProduitFournisseur(String produitFournisseur) {
        this.produitFournisseur = produitFournisseur;
    }

    public String getMarqueProduit() {
        return marqueProduit;
    }

    public void setMarqueProduit(String marqueProduit) {
        this.marqueProduit = marqueProduit;
    }

    public String getProduitNom() {
        return produitNom;
    }

    public void setProduitNom(String produitNom) {
        this.produitNom = produitNom;
    }

    public String getClientVoie() {
        return clientVoie;
    }

    public void setClientVoie(String clientVoie) {
        this.clientVoie = clientVoie;
    }

    public String getClientCp() {
        return clientCp;
    }

    public void setClientCp(String clientCp) {
        this.clientCp = clientCp;
    }

    public String getClientVille() {
        return clientVille;
    }

    public void setClientVille(String clientVille) {
        this.clientVille = clientVille;
    }

    public String getClientTelMobile() {
        return clientTelMobile;
    }

    public void setClientTelMobile(String clientTelMobile) {
        this.clientTelMobile = clientTelMobile;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartoDossier)) {
            return false;
        }
        CartoDossier other = (CartoDossier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CartoDossier{" + "id=" + id + ", tickerRefPartenaire=" + tickerRefPartenaire + ", ticketRefDo=" + ticketRefDo + ", ticketDateOuverture=" + ticketDateOuverture + ", ticketDateMissionnement=" + ticketDateMissionnement + ", interventionDate=" + interventionDate + ", ticketConformite=" + ticketConformite + ", produitRef=" + produitRef + ", produitFournisseur=" + produitFournisseur + ", marqueProduit=" + marqueProduit + ", produitNom=" + produitNom + ", clientVoie=" + clientVoie + ", clientCp=" + clientCp + ", clientVille=" + clientVille + ", clientTelMobile=" + clientTelMobile + ", clientEmail=" + clientEmail + ", clientNom=" + clientNom + '}';
    }

}
