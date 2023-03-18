package com.example.pierp.Models;

import jakarta.persistence.*;

@Entity
public class Garantie {
    private String refGarantie;
    private String refClient;
    private String refVoiture;
    private String reglement;
    private String travaux;
    private Client clientByRefClient;
    private Voiture voitureByRefVoiture;

    @Id
    @Column(name = "ref_garantie")
    public String getRefGarantie() {
        return refGarantie;
    }

    public void setRefGarantie(String refGarantie) {
        this.refGarantie = refGarantie;
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
    @Column(name = "reglement")
    public String getReglement() {
        return reglement;
    }

    public void setReglement(String reglement) {
        this.reglement = reglement;
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

        Garantie garantie = (Garantie) o;

        if (refGarantie != null ? !refGarantie.equals(garantie.refGarantie) : garantie.refGarantie != null)
            return false;
        if (refClient != null ? !refClient.equals(garantie.refClient) : garantie.refClient != null) return false;
        if (refVoiture != null ? !refVoiture.equals(garantie.refVoiture) : garantie.refVoiture != null) return false;
        if (reglement != null ? !reglement.equals(garantie.reglement) : garantie.reglement != null) return false;
        if (travaux != null ? !travaux.equals(garantie.travaux) : garantie.travaux != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refGarantie != null ? refGarantie.hashCode() : 0;
        result = 31 * result + (refClient != null ? refClient.hashCode() : 0);
        result = 31 * result + (refVoiture != null ? refVoiture.hashCode() : 0);
        result = 31 * result + (reglement != null ? reglement.hashCode() : 0);
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
    @JoinColumn(name = "ref_voiture", referencedColumnName = "reference",updatable = false,insertable = false)
    public Voiture getVoitureByRefVoiture() {
        return voitureByRefVoiture;
    }

    public void setVoitureByRefVoiture(Voiture voitureByRefVoiture) {
        this.voitureByRefVoiture = voitureByRefVoiture;
    }
}
