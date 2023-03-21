package com.example.pierp.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nom", nullable = true, length = 255)
    private String nom;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "reference_fabricant", nullable = true, length = 255, insertable = false, updatable = false)
    private String referenceFabricant;
    @Basic
    @Column(name = "reference_interne", nullable = true, length = 255)
    private String referenceInterne;
    @Basic
    @Column(name = "quantite", nullable = true)
    private Integer quantite;
    @Basic
    @Column(name = "prix_unitaire", nullable = true, precision = 2)
    private BigDecimal prixUnitaire;
    @Basic
    @Column(name = "date_ajout", nullable = true)
    private Timestamp dateAjout;
    @Basic
    @Column(name = "categorie", nullable = true, length = 255)
    private String categorie;
    @ManyToOne
    @JoinColumn(name = "reference_fabricant", referencedColumnName = "ref_fournisseur")
    private Fournisseur fournisseurByReferenceFabricant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReferenceFabricant() {
        return referenceFabricant;
    }

    public void setReferenceFabricant(String referenceFabricant) {
        this.referenceFabricant = referenceFabricant;
    }

    public String getReferenceInterne() {
        return referenceInterne;
    }

    public void setReferenceInterne(String referenceInterne) {
        this.referenceInterne = referenceInterne;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (id != produit.id) return false;
        if (nom != null ? !nom.equals(produit.nom) : produit.nom != null) return false;
        if (description != null ? !description.equals(produit.description) : produit.description != null) return false;
        if (referenceFabricant != null ? !referenceFabricant.equals(produit.referenceFabricant) : produit.referenceFabricant != null)
            return false;
        if (referenceInterne != null ? !referenceInterne.equals(produit.referenceInterne) : produit.referenceInterne != null)
            return false;
        if (quantite != null ? !quantite.equals(produit.quantite) : produit.quantite != null) return false;
        if (prixUnitaire != null ? !prixUnitaire.equals(produit.prixUnitaire) : produit.prixUnitaire != null)
            return false;
        if (dateAjout != null ? !dateAjout.equals(produit.dateAjout) : produit.dateAjout != null) return false;
        if (categorie != null ? !categorie.equals(produit.categorie) : produit.categorie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (referenceFabricant != null ? referenceFabricant.hashCode() : 0);
        result = 31 * result + (referenceInterne != null ? referenceInterne.hashCode() : 0);
        result = 31 * result + (quantite != null ? quantite.hashCode() : 0);
        result = 31 * result + (prixUnitaire != null ? prixUnitaire.hashCode() : 0);
        result = 31 * result + (dateAjout != null ? dateAjout.hashCode() : 0);
        result = 31 * result + (categorie != null ? categorie.hashCode() : 0);
        return result;
    }

    public Fournisseur getFournisseurByReferenceFabricant() {
        return fournisseurByReferenceFabricant;
    }

    public void setFournisseurByReferenceFabricant(Fournisseur fournisseurByReferenceFabricant) {
        this.fournisseurByReferenceFabricant = fournisseurByReferenceFabricant;
    }
}
