package com.example.pierp.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Workflow {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;


    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "assigned_by", nullable = false, length = 255)
    private String assignedBy;
    @Basic
    @Column(name = "status", nullable = true)
    private String status;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "p_avant", nullable = false)
    private byte[] pAvant;
    @Basic
    @Column(name = "p_apres", nullable = true)
    private byte[] pApres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workflow workflow = (Workflow) o;

        if (id != null ? !id.equals(workflow.id) : workflow.id != null) return false;
        if (name != null ? !name.equals(workflow.name) : workflow.name != null) return false;
        if (description != null ? !description.equals(workflow.description) : workflow.description != null)
            return false;
        if (assignedBy != null ? !assignedBy.equals(workflow.assignedBy) : workflow.assignedBy != null) return false;
        if (status != null ? !status.equals(workflow.status) : workflow.status != null) return false;
        if (createdAt != null ? !createdAt.equals(workflow.createdAt) : workflow.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(workflow.updatedAt) : workflow.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (assignedBy != null ? assignedBy.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public byte[] getpAvant() {
        return pAvant;
    }

    public void setpAvant(byte[] pAvant) {
        this.pAvant = pAvant;
    }

    public byte[] getpApres() {
        return pApres;
    }

    public void setpApres(byte[] pApres) {
        this.pApres = pApres;
    }
}
