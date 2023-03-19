package com.example.pierp.Controllers;

import com.example.pierp.Models.Facture;
import com.example.pierp.Services.Implementation.FactureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@PreAuthorize("hasAnyRole('RESPONSABLE','ADMIN')")
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    FactureServiceImpl factureService;


    @PostMapping("/addfacture")
    @PreAuthorize("hasAnyRole('RESPONSABLE','ADMIN')")
    public ResponseEntity<String> addFacture(@RequestBody Facture facture) throws Exception {
        if(factureService.addFacture(facture)){
            return ResponseEntity.ok("Facture ajoutée avec succès");
        }
        return ResponseEntity.badRequest().body("Erreur lors de l'ajout de la facture");
    }
    @GetMapping("/getfacture/{reference}")
    @PreAuthorize("hasAnyRole('RESPONSABLE','ADMIN')")
    public ResponseEntity<Facture> getFactureByReference(@PathVariable String reference) throws Exception {
        Facture facture = factureService.getFactureByReference(reference);
        if(facture!=null){
            return ResponseEntity.ok(facture);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/getfactures")
    public ResponseEntity<List<Facture>> getFactures() throws Exception {
        return ResponseEntity.ok(factureService.getFactures());
    }


}
