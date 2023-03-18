package com.example.pierp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "rapport", schema = "pierp")
public class Rapport {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ref_rapport")
    private String refRapport;
    @Basic
    @Column(name = "ref_client")
    private String refClient;
    @Basic
    @Column(name = "ref_voiture")
    private String refVoiture;
    @Basic
    @Column(name = "date_debut")
    private String dateDebut;
    @Basic
    @Column(name = "date_fin")
    private String dateFin;
    @Basic
    @Column(name = "type_travaux")
    private String typeTravaux;
    @Basic
    @Column(name = "description_travaux")
    private String descriptionTravaux;
    @Basic
    @Column(name = "etat_travail")
    private String etatTravail;
    @Basic
    @Column(name = "ref_professionel")
    private String refProfessionel;
    @ManyToOne
    @JoinColumn(name = "ref_client", referencedColumnName = "ref_client", nullable = false,insertable = false,updatable = false)
    private Client clientByRefCl;
    @ManyToOne
    @JoinColumn(name = "ref_voiture", referencedColumnName = "reference", nullable = false,insertable = false,updatable = false)
    private Voiture voitureByRefV;
    @ManyToOne
    @JoinColumn(name = "ref_professionel", referencedColumnName = "cin",nullable = false,insertable = false,updatable = false)
    private Personne personneByRefP;

    public String getRefRapport() {
        return refRapport;
    }

    public void setRefRapport(String refRapport) {
        this.refRapport = refRapport;
    }

    public String getRefClient() {
        return refClient;
    }

    public void setRefClient(String refClient) {
        this.refClient = refClient;
    }

    public String getRefVoiture() {
        return refVoiture;
    }

    public void setRefVoiture(String refVoiture) {
        this.refVoiture = refVoiture;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getTypeTravaux() {
        return typeTravaux;
    }

    public void setTypeTravaux(String typeTravaux) {
        this.typeTravaux = typeTravaux;
    }

    public String getDescriptionTravaux() {
        return descriptionTravaux;
    }

    public void setDescriptionTravaux(String descriptionTravaux) {
        this.descriptionTravaux = descriptionTravaux;
    }

    public String getEtatTravail() {
        return etatTravail;
    }

    public void setEtatTravail(String etatTravail) {
        this.etatTravail = etatTravail;
    }

    public String getRefProfessionel() {
        return refProfessionel;
    }

    public void setRefProfessionel(String refProfessionel) {
        this.refProfessionel = refProfessionel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rapport rapport = (Rapport) o;

        if (refRapport != null ? !refRapport.equals(rapport.refRapport) : rapport.refRapport != null) return false;
        if (refClient != null ? !refClient.equals(rapport.refClient) : rapport.refClient != null) return false;
        if (refVoiture != null ? !refVoiture.equals(rapport.refVoiture) : rapport.refVoiture != null) return false;
        if (dateDebut != null ? !dateDebut.equals(rapport.dateDebut) : rapport.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(rapport.dateFin) : rapport.dateFin != null) return false;
        if (typeTravaux != null ? !typeTravaux.equals(rapport.typeTravaux) : rapport.typeTravaux != null) return false;
        if (descriptionTravaux != null ? !descriptionTravaux.equals(rapport.descriptionTravaux) : rapport.descriptionTravaux != null)
            return false;
        if (etatTravail != null ? !etatTravail.equals(rapport.etatTravail) : rapport.etatTravail != null) return false;
        if (refProfessionel != null ? !refProfessionel.equals(rapport.refProfessionel) : rapport.refProfessionel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refRapport != null ? refRapport.hashCode() : 0;
        result = 31 * result + (refClient != null ? refClient.hashCode() : 0);
        result = 31 * result + (refVoiture != null ? refVoiture.hashCode() : 0);
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + (typeTravaux != null ? typeTravaux.hashCode() : 0);
        result = 31 * result + (descriptionTravaux != null ? descriptionTravaux.hashCode() : 0);
        result = 31 * result + (etatTravail != null ? etatTravail.hashCode() : 0);
        result = 31 * result + (refProfessionel != null ? refProfessionel.hashCode() : 0);
        return result;
    }

    public Client getClientByRefCl() {
        return clientByRefCl;
    }

    public void setClientByRefCl(Client clientByRefCl) {
        this.clientByRefCl = clientByRefCl;
    }

    public Voiture getVoitureByRefV() {
        return voitureByRefV;
    }

    public void setVoitureByRefV(Voiture voitureByRefV) {
        this.voitureByRefV = voitureByRefV;
    }

    public Personne getPersonneByRefP() {
        return personneByRefP;
    }

    public void setPersonneByRefP(Personne personneByRefP) {
        this.personneByRefP = personneByRefP;
    }
}
