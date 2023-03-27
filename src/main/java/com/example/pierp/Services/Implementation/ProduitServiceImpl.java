package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Produit;
import com.example.pierp.Repositories.ProduitRepository;
import com.example.pierp.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProduitServiceImpl implements ProduitService {


    @Autowired
    ProduitRepository produitRepository;
    @Override
    public boolean addProduit(Produit produit) {
        try {
            produitRepository.save(produit);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  false ;
        }
    }

    @Override
    public boolean deleteProduit(String reference) {
        try {

            if(produitRepository.existsById(reference))
                produitRepository.deleteById(reference);

            return true;
        }catch (Exception E){
            System.out.println(E.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateProduit(String refrence) {
        try {
            if(produitRepository.existsById(refrence)){
                Produit produit = produitRepository.findById(refrence).get();
                produitRepository.save(produit);
                return true;
            }
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Produit getProduit(String reference) {
        return produitRepository.findById(reference).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public boolean updateStockProduit(String reference, int Qte,String type) {
       if(produitRepository.existsById(reference)){
           switch (type){
               case "+":
                   Produit produit = produitRepository.findById(reference).get();
                   produit.setQuantite(produit.getQuantite()+Qte);
                     produitRepository.save(produit);
                     return true;
               case "-":
                     Produit produit1 = produitRepository.findById(reference).get();
                     produit1.setQuantite(produit1.getQuantite()-Qte);
                     produitRepository.save(produit1);
                     return true;
               default: return false;
           }
       }
       return false;
    }
}
