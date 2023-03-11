package com.example.pierp.Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Voiture {
    private String reference;
    private String modele;
    private String matricule;
    private String marque;
    private String refDetails;
    private Collection<Depannage> depannagesByReference;
    private Collection<Facture> facturesByReference;
    private Collection<Garantie> garantiesByReference;
    private DetailsVoiture detailsVoitureByRefDetails;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "modele")
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "matricule")
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Basic
    @Column(name = "marque")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "ref_details")
    public String getRefDetails() {
        return refDetails;
    }

    public void setRefDetails(String refDetails) {
        this.refDetails = refDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voiture voiture = (Voiture) o;

        if (reference != null ? !reference.equals(voiture.reference) : voiture.reference != null) return false;
        if (modele != null ? !modele.equals(voiture.modele) : voiture.modele != null) return false;
        if (matricule != null ? !matricule.equals(voiture.matricule) : voiture.matricule != null) return false;
        if (marque != null ? !marque.equals(voiture.marque) : voiture.marque != null) return false;
        if (refDetails != null ? !refDetails.equals(voiture.refDetails) : voiture.refDetails != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reference != null ? reference.hashCode() : 0;
        result = 31 * result + (modele != null ? modele.hashCode() : 0);
        result = 31 * result + (matricule != null ? matricule.hashCode() : 0);
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        result = 31 * result + (refDetails != null ? refDetails.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "voitureByRefVoiture")
    public Collection<Depannage> getDepannagesByReference() {
        return depannagesByReference;
    }

    public void setDepannagesByReference(Collection<Depannage> depannagesByReference) {
        this.depannagesByReference = depannagesByReference;
    }

    @OneToMany(mappedBy = "voitureByRefVoiture")
    public Collection<Facture> getFacturesByReference() {
        return facturesByReference;
    }

    public void setFacturesByReference(Collection<Facture> facturesByReference) {
        this.facturesByReference = facturesByReference;
    }

    @OneToMany(mappedBy = "voitureByRefVoiture")
    public Collection<Garantie> getGarantiesByReference() {
        return garantiesByReference;
    }

    public void setGarantiesByReference(Collection<Garantie> garantiesByReference) {
        this.garantiesByReference = garantiesByReference;
    }

    @ManyToOne
    @JoinColumn(name = "ref_details", referencedColumnName = "ref_details" ,insertable = false,updatable = false)
    public DetailsVoiture getDetailsVoitureByRefDetails() {
        return detailsVoitureByRefDetails;
    }

    public void setDetailsVoitureByRefDetails(DetailsVoiture detailsVoitureByRefDetails) {
        this.detailsVoitureByRefDetails = detailsVoitureByRefDetails;
    }
}
