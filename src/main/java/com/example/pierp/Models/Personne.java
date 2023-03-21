package com.example.pierp.Models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cin")
public class Personne {
    private String cin;
    private String prenom;
    private String nom;
    private String numtel;
    private String role;
    private String password;
    private Role roleByRole;
    private List<Tache> tachesByCin;
    private Collection<Rapport> rapportsByCin;

    @Id
    @Column(name = "cin")
    public String getCin() {
        return cin;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "numtel")
    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (cin != null ? !cin.equals(personne.cin) : personne.cin != null) return false;
        if (prenom != null ? !prenom.equals(personne.prenom) : personne.prenom != null) return false;
        if (nom != null ? !nom.equals(personne.nom) : personne.nom != null) return false;
        if (numtel != null ? !numtel.equals(personne.numtel) : personne.numtel != null) return false;
        if (role != null ? !role.equals(personne.role) : personne.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cin != null ? cin.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (numtel != null ? numtel.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "ref_role", updatable = false, insertable = false)
    public Role getRoleByRole() {
        return roleByRole;
    }

    public void setRoleByRole(Role roleByRole) {
        this.roleByRole = roleByRole;
    }

    @OneToMany(mappedBy = "personneByResponsable")
    public List<Tache> getTachesByCin() {
        return tachesByCin;
    }

    public void setTachesByCin(List<Tache> tachesByCin) {
        this.tachesByCin = tachesByCin;
    }

    @OneToMany(mappedBy = "personneByRefP")
    public Collection<Rapport> getRapportsByCin() {
        return rapportsByCin;
    }

    public void setRapportsByCin(Collection<Rapport> rapportsByCin) {
        this.rapportsByCin = rapportsByCin;
    }
}
