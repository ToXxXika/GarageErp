package com.example.pierp.Repositories;

import com.example.pierp.Models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FactureRepository  extends JpaRepository<Facture, String> {
}
