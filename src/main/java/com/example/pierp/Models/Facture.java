package com.example.pierp.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "refFacture")
public class Facture {
    private String refFacture;
    private String dateFacture;
    private Double montant;
    private String refClient;
    private String refVoiture;
    private String matriculeVoiture;
    private String travaux;
    private Client clientByRefClient;
    private Voiture voitureByRefVoiture;

    @Id
    @Column(name = "ref_facture")
    public String getRefFacture() {
        return refFacture;
    }

    public void setRefFacture(String refFacture) {
        this.refFacture = refFacture;
    }

    @Basic
    @Column(name = "date_facture")
    public String getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(String dateFacture) {
        this.dateFacture = dateFacture;
    }

    @Basic
    @Column(name = "montant")
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Basic
    @Column(name = "ref_client")
    public String getRefClient() {
        return refClient;
    }

    public void setRefClient(String refClient) {
        this.refClient = refClient;
    }

    @Basic
    @Column(name = "ref_voiture")
    public String getRefVoiture() {
        return refVoiture;
    }

    public void setRefVoiture(String refVoiture) {
        this.refVoiture = refVoiture;
    }

    @Basic
    @Column(name = "matricule_voiture")
    public String getMatriculeVoiture() {
        return matriculeVoiture;
    }

    public void setMatriculeVoiture(String matriculeVoiture) {
        this.matriculeVoiture = matriculeVoiture;
    }

    @Basic
    @Column(name = "travaux")
    public String getTravaux() {
        return travaux;
    }

    public void setTravaux(String travaux) {
        this.travaux = travaux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facture facture = (Facture) o;

        if (refFacture != null ? !refFacture.equals(facture.refFacture) : facture.refFacture != null) return false;
        if (dateFacture != null ? !dateFacture.equals(facture.dateFacture) : facture.dateFacture != null) return false;
        if (montant != null ? !montant.equals(facture.montant) : facture.montant != null) return false;
        if (refClient != null ? !refClient.equals(facture.refClient) : facture.refClient != null) return false;
        if (refVoiture != null ? !refVoiture.equals(facture.refVoiture) : facture.refVoiture != null) return false;
        if (matriculeVoiture != null ? !matriculeVoiture.equals(facture.matriculeVoiture) : facture.matriculeVoiture != null)
            return false;
        if (travaux != null ? !travaux.equals(facture.travaux) : facture.travaux != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refFacture != null ? refFacture.hashCode() : 0;
        result = 31 * result + (dateFacture != null ? dateFacture.hashCode() : 0);
        result = 31 * result + (montant != null ? montant.hashCode() : 0);
        result = 31 * result + (refClient != null ? refClient.hashCode() : 0);
        result = 31 * result + (refVoiture != null ? refVoiture.hashCode() : 0);
        result = 31 * result + (matriculeVoiture != null ? matriculeVoiture.hashCode() : 0);
        result = 31 * result + (travaux != null ? travaux.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ref_client", referencedColumnName = "ref_client",updatable = false,insertable = false)
    public Client getClientByRefClient() {
        return clientByRefClient;
    }

    public void setClientByRefClient(Client clientByRefClient) {
        this.clientByRefClient = clientByRefClient;
    }

    @ManyToOne
    @JoinColumn(name = "ref_voiture", referencedColumnName = "reference",insertable = false,updatable = false)
    public Voiture getVoitureByRefVoiture() {
        return voitureByRefVoiture;
    }

    public void setVoitureByRefVoiture(Voiture voitureByRefVoiture) {
        this.voitureByRefVoiture = voitureByRefVoiture;
    }
}
