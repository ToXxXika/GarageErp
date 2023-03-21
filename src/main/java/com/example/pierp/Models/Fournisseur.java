package com.example.pierp.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "refFournisseur")
public class Fournisseur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ref_fournisseur", nullable = false, length = 255)
    private String refFournisseur;
    @Basic
    @Column(name = "nom_fournisseur", nullable = false, length = 255)
    private String nomFournisseur;
    @Basic
    @Column(name = "adresse_fournisseur", nullable = false, length = 255)
    private String adresseFournisseur;
    @Basic
    @Column(name = "tel_fournisseur", nullable = false, length = 255)
    private String telFournisseur;
    @Basic
    @Column(name = "email_fournisseur", nullable = false, length = 255)
    private String emailFournisseur;
    @OneToMany(mappedBy = "fournisseurByRefF")
    private Collection<Piece> piecesByRefFournisseur;
    @OneToMany(mappedBy = "fournisseurByReferenceFabricant")
    private Collection<Produit> produitsByRefFournisseur;

    public String getRefFournisseur() {
        return refFournisseur;
    }

    public void setRefFournisseur(String refFournisseur) {
        this.refFournisseur = refFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public String getTelFournisseur() {
        return telFournisseur;
    }

    public void setTelFournisseur(String telFournisseur) {
        this.telFournisseur = telFournisseur;
    }

    public String getEmailFournisseur() {
        return emailFournisseur;
    }

    public void setEmailFournisseur(String emailFournisseur) {
        this.emailFournisseur = emailFournisseur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fournisseur that = (Fournisseur) o;

        if (refFournisseur != null ? !refFournisseur.equals(that.refFournisseur) : that.refFournisseur != null)
            return false;
        if (nomFournisseur != null ? !nomFournisseur.equals(that.nomFournisseur) : that.nomFournisseur != null)
            return false;
        if (adresseFournisseur != null ? !adresseFournisseur.equals(that.adresseFournisseur) : that.adresseFournisseur != null)
            return false;
        if (telFournisseur != null ? !telFournisseur.equals(that.telFournisseur) : that.telFournisseur != null)
            return false;
        if (emailFournisseur != null ? !emailFournisseur.equals(that.emailFournisseur) : that.emailFournisseur != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refFournisseur != null ? refFournisseur.hashCode() : 0;
        result = 31 * result + (nomFournisseur != null ? nomFournisseur.hashCode() : 0);
        result = 31 * result + (adresseFournisseur != null ? adresseFournisseur.hashCode() : 0);
        result = 31 * result + (telFournisseur != null ? telFournisseur.hashCode() : 0);
        result = 31 * result + (emailFournisseur != null ? emailFournisseur.hashCode() : 0);
        return result;
    }

    public Collection<Piece> getPiecesByRefFournisseur() {
        return piecesByRefFournisseur;
    }

    public void setPiecesByRefFournisseur(Collection<Piece> piecesByRefFournisseur) {
        this.piecesByRefFournisseur = piecesByRefFournisseur;
    }

    public Collection<Produit> getProduitsByRefFournisseur() {
        return produitsByRefFournisseur;
    }

    public void setProduitsByRefFournisseur(Collection<Produit> produitsByRefFournisseur) {
        this.produitsByRefFournisseur = produitsByRefFournisseur;
    }
}
