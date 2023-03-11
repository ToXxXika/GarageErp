package com.example.pierp.Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Role {
    private String refRole;
    private String description;
    private Collection<Personne> personnesByRefRole;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ref_role")
    public String getRefRole() {
        return refRole;
    }

    public void setRefRole(String refRole) {
        this.refRole = refRole;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (refRole != null ? !refRole.equals(role.refRole) : role.refRole != null) return false;
        if (description != null ? !description.equals(role.description) : role.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refRole != null ? refRole.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRole")
    public Collection<Personne> getPersonnesByRefRole() {
        return personnesByRefRole;
    }

    public void setPersonnesByRefRole(Collection<Personne> personnesByRefRole) {
        this.personnesByRefRole = personnesByRefRole;
    }
}
