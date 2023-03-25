package com.example.pierp.Controllers;

import com.example.pierp.Models.Piece;
import com.example.pierp.Services.Implementation.PieceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/piece")
public class PieceController {


    PieceServiceImpl pieceService;

    @PostMapping("/addpiece")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public ResponseEntity<String> addPiece(@RequestBody Piece piece) {
        if(pieceService.addPiece(piece)){
            return ResponseEntity.ok("Piece added successfully");
        }
        return ResponseEntity.badRequest().body("Error while adding the piece");
    }

    @GetMapping("/getpiece/{reference}")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public ResponseEntity<Piece> getPiece( @PathVariable("reference") String reference) {
        Piece piece = pieceService.getPiece(reference);
        if (piece == null) {
            return ResponseEntity.badRequest().body(piece);
        } else {
            return ResponseEntity.ok(piece);
        }
    }

    @PostMapping("/updatepiece/{reference}/{Qte}")
    public ResponseEntity<String> updatepiece(@PathVariable("reference") String reference, @PathVariable("Qte") int Qte) {
        if(pieceService.updatePiece(reference,Qte)){
            return ResponseEntity.ok("Piece updated successfully");
        }
        return ResponseEntity.badRequest().body("Error while updating the piece");
    }


}
