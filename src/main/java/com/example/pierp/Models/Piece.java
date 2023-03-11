package com.example.pierp.Models;

import jakarta.persistence.*;

@Entity
public class Piece {
    private String reference;
    private String designation;
    private String fournisseur;
    private Double prixVenteHt;
    private Integer qteStock;
    private Integer baremeHt;
    private String fConstructeur;
    private Double tauxTva;
    private String dateSortie;

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
    @Column(name = "designation")
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Basic
    @Column(name = "fournisseur")
    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Basic
    @Column(name = "prix_vente_ht")
    public Double getPrixVenteHt() {
        return prixVenteHt;
    }

    public void setPrixVenteHt(Double prixVenteHt) {
        this.prixVenteHt = prixVenteHt;
    }

    @Basic
    @Column(name = "qte_stock")
    public Integer getQteStock() {
        return qteStock;
    }

    public void setQteStock(Integer qteStock) {
        this.qteStock = qteStock;
    }

    @Basic
    @Column(name = "bareme_ht")
    public Integer getBaremeHt() {
        return baremeHt;
    }

    public void setBaremeHt(Integer baremeHt) {
        this.baremeHt = baremeHt;
    }

    @Basic
    @Column(name = "f_constructeur")
    public String getfConstructeur() {
        return fConstructeur;
    }

    public void setfConstructeur(String fConstructeur) {
        this.fConstructeur = fConstructeur;
    }

    @Basic
    @Column(name = "taux_tva")
    public Double getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(Double tauxTva) {
        this.tauxTva = tauxTva;
    }

    @Basic
    @Column(name = "date_sortie")
    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (reference != null ? !reference.equals(piece.reference) : piece.reference != null) return false;
        if (designation != null ? !designation.equals(piece.designation) : piece.designation != null) return false;
        if (fournisseur != null ? !fournisseur.equals(piece.fournisseur) : piece.fournisseur != null) return false;
        if (prixVenteHt != null ? !prixVenteHt.equals(piece.prixVenteHt) : piece.prixVenteHt != null) return false;
        if (qteStock != null ? !qteStock.equals(piece.qteStock) : piece.qteStock != null) return false;
        if (baremeHt != null ? !baremeHt.equals(piece.baremeHt) : piece.baremeHt != null) return false;
        if (fConstructeur != null ? !fConstructeur.equals(piece.fConstructeur) : piece.fConstructeur != null)
            return false;
        if (tauxTva != null ? !tauxTva.equals(piece.tauxTva) : piece.tauxTva != null) return false;
        if (dateSortie != null ? !dateSortie.equals(piece.dateSortie) : piece.dateSortie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reference != null ? reference.hashCode() : 0;
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (fournisseur != null ? fournisseur.hashCode() : 0);
        result = 31 * result + (prixVenteHt != null ? prixVenteHt.hashCode() : 0);
        result = 31 * result + (qteStock != null ? qteStock.hashCode() : 0);
        result = 31 * result + (baremeHt != null ? baremeHt.hashCode() : 0);
        result = 31 * result + (fConstructeur != null ? fConstructeur.hashCode() : 0);
        result = 31 * result + (tauxTva != null ? tauxTva.hashCode() : 0);
        result = 31 * result + (dateSortie != null ? dateSortie.hashCode() : 0);
        return result;
    }
}
