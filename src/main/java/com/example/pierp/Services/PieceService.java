package com.example.pierp.Services;

import com.example.pierp.Models.Piece;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PieceService  {


     boolean addPiece(Piece piece);

     List<Piece> getAllPieces();

     boolean updatePiece(String reference,int Qte);
     Piece getPiece(String reference);

     boolean ImportPieceCsv(MultipartFile file) throws IOException;

}
