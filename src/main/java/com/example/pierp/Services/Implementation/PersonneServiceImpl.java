package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Personne;
import com.example.pierp.Repositories.ClientRepository;
import com.example.pierp.Repositories.PersonneRepository;
import com.example.pierp.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    ClientRepository clientRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public Principal login(Principal principal) {
        return principal;
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

    @Override
    public Personne loadUserByUsername(String cin) {

       if(personneRepository.findById(cin).isPresent()){
           System.out.println("personne found");
           return personneRepository.findById(cin).get();
       }
       System.out.println("personne not found");
         return null;
    }




}
