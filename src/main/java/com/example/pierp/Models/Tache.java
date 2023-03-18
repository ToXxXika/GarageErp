package com.example.pierp.Models;

import jakarta.persistence.*;

@Entity
public class Tache {
    private String refTache;
    private String refClient;
    private String description;
    private String responsable;
    private String etat;

    private Personne personneByResponsable;

    @Basic
    @Column(name = "etat")

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Id
    @Column(name = "ref_tache")
    public String getRefTache() {
        return refTache;
    }

    public void setRefTache(String refTache) {
        this.refTache = refTache;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "responsable")
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tache tache = (Tache) o;

        if (refTache != null ? !refTache.equals(tache.refTache) : tache.refTache != null) return false;
        if (refClient != null ? !refClient.equals(tache.refClient) : tache.refClient != null) return false;
        if (description != null ? !description.equals(tache.description) : tache.description != null) return false;
        if (responsable != null ? !responsable.equals(tache.responsable) : tache.responsable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refTache != null ? refTache.hashCode() : 0;
        result = 31 * result + (refClient != null ? refClient.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (responsable != null ? responsable.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "responsable", referencedColumnName = "cin", nullable = false,updatable = false,insertable = false)
    public Personne getPersonneByResponsable() {
        return personneByResponsable;
    }

    public void setPersonneByResponsable(Personne personneByResponsable) {
        this.personneByResponsable = personneByResponsable;
    }
}
