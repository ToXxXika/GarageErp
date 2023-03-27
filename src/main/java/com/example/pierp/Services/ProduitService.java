package com.example.pierp.Services;

import com.example.pierp.Models.Produit;

import java.util.List;

public interface ProduitService {
    //CRUD for produit
    boolean addProduit(Produit produit);
    boolean deleteProduit(String reference);
    boolean updateProduit(String refrence);
    Produit getProduit(String reference);
    List<Produit> getAllProduits();
     boolean updateStockProduit(String reference,int Qte,String type);

}
