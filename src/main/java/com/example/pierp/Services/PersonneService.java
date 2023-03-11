package com.example.pierp.Services;


import org.springframework.stereotype.Service;
import com.example.pierp.Models.Personne;

import java.util.List;


public interface PersonneService {
   public boolean addPersonne(Personne personne);
   public boolean deletePersonne(String cin);

   public List<Personne> getAllPersonnes();
  // public boolean addtask(String cin,Tache task );
   //public boolean

}
