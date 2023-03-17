package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Piece;
import com.example.pierp.Repositories.PieceRepository;
import com.example.pierp.Services.PieceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PieceServiceImpl implements PieceService {

    @Autowired
    PieceRepository pieceRepository;
    @Override
    public boolean addPiece(Piece piece) {
        try {
            pieceRepository.save(piece);
            System.out.println("Piece added successfully");
            return true;
        } catch (Exception e) {
            System.out.println("Cause: "+e.getCause()+" \n Message  : "+e.getMessage());
            return false;
        }
    }

    @Override
    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }

    @Override
    public boolean updatePiece(String reference,int Qte) {
        try {
             Piece piece = pieceRepository.findById(reference).get();
                piece.setQteStock(piece.getQteStock()-Qte);
                pieceRepository.saveAndFlush(piece);
                System.out.println("Piece updated successfully");
            return true ;
        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause() + " \n Message  : " + e.getMessage());
            return false;
        }
    }
    @Override
    public Piece getPiece(String reference) {

        return  pieceRepository.findById(reference).get();
    }
}
