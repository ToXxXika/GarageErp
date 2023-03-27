package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Tache;
import com.example.pierp.Repositories.TacheRepository;
import com.example.pierp.Services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl  implements TacheService {

    @Autowired
    TacheRepository tacheRepository;

    @Override
    public boolean ajouterTache(Tache tache) {
        try{
            tacheRepository.save(tache);
            System.out.println("Tache added successfully");
            return true;
        }catch (Exception E){
            System.out.println(E);

            return false;
        }
    }

    @Override
    public boolean modifierEtatTache(String reftache, String etat) {
       if(tacheRepository.existsById(reftache)){
           Tache tache = tacheRepository.findById(reftache).get();
           tache.setEtat(etat);
           tacheRepository.save(tache);
           return true;
       }
       return false ;
    }

    @Override
    public boolean supprimerTache(String reftache) {
        if(tacheRepository.existsById(reftache)){
            tacheRepository.deleteById(reftache);
            return true;
        }
        return false;
    }

    @Override
    public List<Tache> getTachesByUser(String professionel) {
        return tacheRepository.findAllByProfessionel(professionel);
    }
}
