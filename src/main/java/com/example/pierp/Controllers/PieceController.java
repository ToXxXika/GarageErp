package com.example.pierp.Controllers;

import com.example.pierp.Models.Piece;
import com.example.pierp.Services.Implementation.PieceServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/piece")
public class PieceController {


    PieceServiceImpl pieceService;

    @PostMapping("/addpiece")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public boolean addPiece(@RequestBody Piece piece) {
        return pieceService.addPiece(piece);
    }

    @GetMapping("/getpiece/{reference}")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public Piece getPiece( @PathVariable("reference") String reference) {
        return pieceService.getPiece(reference);
    }

    @PostMapping("/updatepiece/{reference}/{Qte}")
    public boolean updatepiece(@PathVariable("reference") String reference, @PathVariable("Qte") int Qte) {
        return pieceService.updatePiece(reference, Qte);
    }


}
