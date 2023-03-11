package com.example.pierp.Services;

import com.example.pierp.Models.Piece;
import com.example.pierp.Repositories.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PieceService  {


    public boolean addPiece(Piece piece);

    public List<Piece> getAllPieces();
}
