package com.example.pierp.Repositories;

import com.example.pierp.Models.Garantie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarantieRepository extends JpaRepository<Garantie, String> {

}
