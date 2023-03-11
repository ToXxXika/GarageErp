package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Personne;
import com.example.pierp.Repositories.PersonneRepository;
import com.example.pierp.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {
    @Autowired
    PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public boolean addPersonne(Personne personne) {
        try {
            personneRepository.save(personne);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deletePersonne(String cin) {
        return false;
    }

    @Override
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

}
