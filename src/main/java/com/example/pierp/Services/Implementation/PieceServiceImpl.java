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
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }
}
