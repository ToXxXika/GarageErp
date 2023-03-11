package com.example.pierp.Models;

import jakarta.persistence.*;

@Entity
public class Depannage {
    private int id;
    private String refVoiture;
    private String status;
    private String refClient;
    private Voiture voitureByRefVoiture;
    private Client clientByRefClient;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ref_client")
    public String getRefClient() {
        return refClient;
    }

    public void setRefClient(String refClient) {
        this.refClient = refClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Depannage depannage = (Depannage) o;

        if (id != depannage.id) return false;
        if (refVoiture != null ? !refVoiture.equals(depannage.refVoiture) : depannage.refVoiture != null) return false;
        if (status != null ? !status.equals(depannage.status) : depannage.status != null) return false;
        if (refClient != null ? !refClient.equals(depannage.refClient) : depannage.refClient != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (refVoiture != null ? refVoiture.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (refClient != null ? refClient.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ref_voiture", referencedColumnName = "reference", nullable = false, insertable = false, updatable = false)
    public Voiture getVoitureByRefVoiture() {
        return voitureByRefVoiture;
    }

    public void setVoitureByRefVoiture(Voiture voitureByRefVoiture) {
        this.voitureByRefVoiture = voitureByRefVoiture;
    }

    @ManyToOne
    @JoinColumn(name = "ref_client", referencedColumnName = "ref_client", nullable = false, insertable = false, updatable = false)
    public Client getClientByRefClient() {
        return clientByRefClient;
    }

    public void setClientByRefClient(Client clientByRefClient) {
        this.clientByRefClient = clientByRefClient;
    }
}
