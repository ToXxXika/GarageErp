package com.example.pierp.Services;


import com.example.pierp.Models.Personne;
import org.springframework.security.core.userdetails.User;

import java.util.List;


public interface PersonneService {
   public boolean addPersonne(Personne personne);
   public boolean deletePersonne(String cin);

   public List<Personne> getAllPersonnes();

    Personne loadUserByUsername(String username);

}
