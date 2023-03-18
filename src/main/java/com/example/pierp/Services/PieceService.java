package com.example.pierp.Services;

import com.example.pierp.Models.Piece;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PieceService  {


     boolean addPiece(Piece piece);

     List<Piece> getAllPieces();

     boolean updatePiece(String reference,int Qte);
     Piece getPiece(String reference);

}
