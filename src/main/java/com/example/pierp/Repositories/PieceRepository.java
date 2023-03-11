package com.example.pierp.Repositories;

import com.example.pierp.Models.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PieceRepository extends JpaRepository<Piece, String>{
}
