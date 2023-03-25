package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Voiture;
import com.example.pierp.Repositories.VoitureRepository;
import com.example.pierp.Services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    VoitureRepository voitureRepository;
    @Override
    public boolean AddVoiture(Voiture voiture) {
        try {
            voitureRepository.save(voiture);
            return true;
        }catch (Exception e){
            System.out.println("Cause: "+e.getCause()+" \n Message  : "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean DeleteVoiture(String matricule) {
        try {
            voitureRepository.deleteById(matricule);
            return true;
        }catch (Exception e){
            System.out.println("Cause: "+e.getCause()+" \n Message  : "+e.getMessage());
            return false;
        }
    }

    @Override
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }
}
