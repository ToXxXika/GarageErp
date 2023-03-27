package com.example.pierp.Repositories;


import com.example.pierp.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository  extends JpaRepository<Produit,String> {
}
