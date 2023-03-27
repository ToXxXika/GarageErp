package com.example.pierp.Services;

import com.example.pierp.Models.Tache;

import java.util.List;

public interface TacheService {
    boolean ajouterTache(Tache tache);
    boolean modifierEtatTache(String reftache, String etat);
    boolean supprimerTache(String reftache);

    List<Tache> getTachesByUser(String professionel);
}
