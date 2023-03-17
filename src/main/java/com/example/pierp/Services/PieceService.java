package com.example.pierp.Services;

import com.example.pierp.Models.Piece;
import com.example.pierp.Repositories.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PieceService  {


     boolean addPiece(Piece piece);

     List<Piece> getAllPieces();

     boolean updatePiece(String reference,int Qte);
     Piece getPiece(String reference);

}
