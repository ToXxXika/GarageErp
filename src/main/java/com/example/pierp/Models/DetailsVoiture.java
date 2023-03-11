package com.example.pierp.Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "details_voiture", schema = "pierp", catalog = "")
public class DetailsVoiture {
    private String refDetails;
    private String carrosserie;
    private String energie;
    private Integer puissance;
    private Integer nbPlaces;
    private Integer nPlaque;
    private Collection<Voiture> voituresByRefDetails;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ref_details")
    public String getRefDetails() {
        return refDetails;
    }

    public void setRefDetails(String refDetails) {
        this.refDetails = refDetails;
    }

    @Basic
    @Column(name = "carrosserie")
    public String getCarrosserie() {
        return carrosserie;
    }

    public void setCarrosserie(String carrosserie) {
        this.carrosserie = carrosserie;
    }

    @Basic
    @Column(name = "energie")
    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    @Basic
    @Column(name = "puissance")
    public Integer getPuissance() {
        return puissance;
    }

    public void setPuissance(Integer puissance) {
        this.puissance = puissance;
    }

    @Basic
    @Column(name = "nb_places")
    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    @Basic
    @Column(name = "n_plaque")
    public Integer getnPlaque() {
        return nPlaque;
    }

    public void setnPlaque(Integer nPlaque) {
        this.nPlaque = nPlaque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailsVoiture that = (DetailsVoiture) o;

        if (refDetails != null ? !refDetails.equals(that.refDetails) : that.refDetails != null) return false;
        if (carrosserie != null ? !carrosserie.equals(that.carrosserie) : that.carrosserie != null) return false;
        if (energie != null ? !energie.equals(that.energie) : that.energie != null) return false;
        if (puissance != null ? !puissance.equals(that.puissance) : that.puissance != null) return false;
        if (nbPlaces != null ? !nbPlaces.equals(that.nbPlaces) : that.nbPlaces != null) return false;
        if (nPlaque != null ? !nPlaque.equals(that.nPlaque) : that.nPlaque != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refDetails != null ? refDetails.hashCode() : 0;
        result = 31 * result + (carrosserie != null ? carrosserie.hashCode() : 0);
        result = 31 * result + (energie != null ? energie.hashCode() : 0);
        result = 31 * result + (puissance != null ? puissance.hashCode() : 0);
        result = 31 * result + (nbPlaces != null ? nbPlaces.hashCode() : 0);
        result = 31 * result + (nPlaque != null ? nPlaque.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "detailsVoitureByRefDetails")
    public Collection<Voiture> getVoituresByRefDetails() {
        return voituresByRefDetails;
    }

    public void setVoituresByRefDetails(Collection<Voiture> voituresByRefDetails) {
        this.voituresByRefDetails = voituresByRefDetails;
    }
}
