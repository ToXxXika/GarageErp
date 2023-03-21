package com.example.pierp.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reference")
public class Piece {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reference", nullable = false, length = 255)
    private String reference;
    @Basic
    @Column(name = "designation", nullable = false, length = 255)
    private String designation;
    @Basic
    @Column(name = "ref_f", nullable = false, length = 255, insertable = false, updatable = false)
    private String refF;
    @Basic
    @Column(name = "prix_vente_ht", nullable = false, precision = 0)
    private double prixVenteHt;
    @Basic
    @Column(name = "qte_stock", nullable = false)
    private int qteStock;
    @Basic
    @Column(name = "bareme_ht", nullable = false)
    private int baremeHt;
    @Basic
    @Column(name = "f_constructeur", nullable = false, length = 255)
    private String fConstructeur;
    @Basic
    @Column(name = "taux_tva", nullable = false, precision = 0)
    private double tauxTva;
    @Basic
    @Column(name = "date_sortie", nullable = false, length = 255)
    private String dateSortie;
    @ManyToOne
    @JoinColumn(name = "ref_f", referencedColumnName = "ref_fournisseur", nullable = false)
    private Fournisseur fournisseurByRefF;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRefF() {
        return refF;
    }

    public void setRefF(String refF) {
        this.refF = refF;
    }

    public double getPrixVenteHt() {
        return prixVenteHt;
    }

    public void setPrixVenteHt(double prixVenteHt) {
        this.prixVenteHt = prixVenteHt;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public int getBaremeHt() {
        return baremeHt;
    }

    public void setBaremeHt(int baremeHt) {
        this.baremeHt = baremeHt;
    }

    public String getfConstructeur() {
        return fConstructeur;
    }

    public void setfConstructeur(String fConstructeur) {
        this.fConstructeur = fConstructeur;
    }

    public double getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(double tauxTva) {
        this.tauxTva = tauxTva;
    }

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

        if (Double.compare(piece.prixVenteHt, prixVenteHt) != 0) return false;
        if (qteStock != piece.qteStock) return false;
        if (baremeHt != piece.baremeHt) return false;
        if (Double.compare(piece.tauxTva, tauxTva) != 0) return false;
        if (reference != null ? !reference.equals(piece.reference) : piece.reference != null) return false;
        if (designation != null ? !designation.equals(piece.designation) : piece.designation != null) return false;
        if (refF != null ? !refF.equals(piece.refF) : piece.refF != null) return false;
        if (fConstructeur != null ? !fConstructeur.equals(piece.fConstructeur) : piece.fConstructeur != null)
            return false;
        if (dateSortie != null ? !dateSortie.equals(piece.dateSortie) : piece.dateSortie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = reference != null ? reference.hashCode() : 0;
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (refF != null ? refF.hashCode() : 0);
        temp = Double.doubleToLongBits(prixVenteHt);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + qteStock;
        result = 31 * result + baremeHt;
        result = 31 * result + (fConstructeur != null ? fConstructeur.hashCode() : 0);
        temp = Double.doubleToLongBits(tauxTva);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateSortie != null ? dateSortie.hashCode() : 0);
        return result;
    }

    public Fournisseur getFournisseurByRefF() {
        return fournisseurByRefF;
    }

    public void setFournisseurByRefF(Fournisseur fournisseurByRefF) {
        this.fournisseurByRefF = fournisseurByRefF;
    }
}
