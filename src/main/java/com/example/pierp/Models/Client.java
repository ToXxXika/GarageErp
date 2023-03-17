package com.example.pierp.Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Client {
    private String refClient;
    private String voiture;
    private String cGrise;
    private Collection<Depannage> depannagesByRefClient;
    private Collection<Facture> facturesByRefClient;
    private Collection<Garantie> garantiesByRefClient;

    @Id
    @Column(name = "ref_client")
    public String getRefClient() {
        return refClient;
    }

    public void setRefClient(String refClient) {
        this.refClient = refClient;
    }

    @Basic
    @Column(name = "voiture")
    public String getVoiture() {
        return voiture;
    }

    public void setVoiture(String voiture) {
        this.voiture = voiture;
    }

    @Basic
    @Column(name = "c_grise")
    public String getcGrise() {
        return cGrise;
    }

    public void setcGrise(String cGrise) {
        this.cGrise = cGrise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (refClient != null ? !refClient.equals(client.refClient) : client.refClient != null) return false;
        if (voiture != null ? !voiture.equals(client.voiture) : client.voiture != null) return false;
        if (cGrise != null ? !cGrise.equals(client.cGrise) : client.cGrise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refClient != null ? refClient.hashCode() : 0;
        result = 31 * result + (voiture != null ? voiture.hashCode() : 0);
        result = 31 * result + (cGrise != null ? cGrise.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByRefClient")
    public Collection<Depannage> getDepannagesByRefClient() {
        return depannagesByRefClient;
    }

    public void setDepannagesByRefClient(Collection<Depannage> depannagesByRefClient) {
        this.depannagesByRefClient = depannagesByRefClient;
    }

    @OneToMany(mappedBy = "clientByRefClient")
    public Collection<Facture> getFacturesByRefClient() {
        return facturesByRefClient;
    }

    public void setFacturesByRefClient(Collection<Facture> facturesByRefClient) {
        this.facturesByRefClient = facturesByRefClient;
    }

    @OneToMany(mappedBy = "clientByRefClient")
    public Collection<Garantie> getGarantiesByRefClient() {
        return garantiesByRefClient;
    }

    public void setGarantiesByRefClient(Collection<Garantie> garantiesByRefClient) {
        this.garantiesByRefClient = garantiesByRefClient;
    }
}
