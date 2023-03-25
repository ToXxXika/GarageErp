package com.example.pierp.Services;

import com.example.pierp.Models.Voiture;

import java.util.List;

public interface VoitureService {

    boolean AddVoiture(Voiture voiture);

    boolean DeleteVoiture(String matricule);
    List<Voiture> getAllVoitures();



}
