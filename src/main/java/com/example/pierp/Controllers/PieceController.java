package com.example.pierp.Controllers;

import com.example.pierp.Models.Piece;
import com.example.pierp.Models.Produit;
import com.example.pierp.Services.Implementation.PieceServiceImpl;
import com.example.pierp.Services.Implementation.ProduitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
@RequestMapping("/material")
public class PieceController {


    @Autowired
    PieceServiceImpl pieceService;
    @Autowired
    ProduitServiceImpl produitService;

    @PostMapping("/produit/addproduit")
    public ResponseEntity<String> addproduit(@RequestBody Produit produit) {
        if(produitService.addProduit(produit)){
            return ResponseEntity.ok("Produit added successfully");
        }
        return ResponseEntity.badRequest().body("Error while adding the produit , Check addProduit method in ProduitServiceImpl class");

    }
    @DeleteMapping("/produit/deleteproduit/{reference}")
    public ResponseEntity<String> deleteproduit(@PathVariable("reference") String reference) {
        if(produitService.deleteProduit(reference)){
            return ResponseEntity.ok("Produit deleted successfully");
        }
        return ResponseEntity.badRequest().body("Error while deleting the produit , Check deleteProduit method in ProduitServiceImpl class");
    }
    @PutMapping("/produit/updateproduit/{reference}")
    public ResponseEntity<String> updateproduit(@PathVariable("reference") String reference) {
        if(produitService.updateProduit(reference)){
            return ResponseEntity.ok("Produit updated successfully");
        }
        return ResponseEntity.badRequest().body("Error while updating the produit , Check updateProduit method in ProduitServiceImpl class");
    }
    @PutMapping("/produit/updateproduit/{reference}/{Qte}")
    public ResponseEntity<String> updateproduit(@PathVariable("reference") String reference, @PathVariable("Qte") int Qte) {
        if(produitService.updateStockProduit(reference,Qte,"add")){
            return ResponseEntity.ok("Produit updated successfully");
        }
        return ResponseEntity.badRequest().body("Error while updating the produit , Check updateStockProduit method in ProduitServiceImpl class");
    }
    @GetMapping("/produit/getproduit/{reference}")
    public ResponseEntity<Produit> getproduit( @PathVariable("reference") String reference) {
        Produit produit = produitService.getProduit(reference);
        if (produit == null) {
            return ResponseEntity.badRequest().body(produit);
        } else {
            return ResponseEntity.ok(produit);
        }
    }
    @GetMapping("/produit/getallproduits")
    public ResponseEntity<List<Produit>> getallproduits() {
        List<Produit> produits = produitService.getAllProduits();
        if (produits == null) {
            return ResponseEntity.badRequest().body(produits);
        } else {
            return ResponseEntity.ok(produits);
        }
    }

    @PostMapping("/piece/addpiece")

    public ResponseEntity<String> addPiece(@RequestBody Piece piece) {
        if(pieceService.addPiece(piece)){
            return ResponseEntity.ok("Piece added successfully");
        }
        return ResponseEntity.badRequest().body("Error while adding the piece");
    }

    @GetMapping("/piece/getpiece/{reference}")

    public ResponseEntity<Piece> getPiece( @PathVariable("reference") String reference) {
        Piece piece = pieceService.getPiece(reference);
        if (piece == null) {
            return ResponseEntity.badRequest().body(piece);
        } else {
            return ResponseEntity.ok(piece);
        }
    }

    @PostMapping("/piece/updatepiece/{reference}/{Qte}")
    public ResponseEntity<String> updatepiece(@PathVariable("reference") String reference, @PathVariable("Qte") int Qte) {
        if(pieceService.updatePiece(reference,Qte)){
            return ResponseEntity.ok("Piece updated successfully");
        }
        return ResponseEntity.badRequest().body("Error while updating the piece");
    }


}
