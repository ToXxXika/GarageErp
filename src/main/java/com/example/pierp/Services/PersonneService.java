package com.example.pierp.Services;


import com.example.pierp.Models.Personne;

import java.security.Principal;
import java.util.List;


public interface PersonneService {

    Principal login(Principal principal);
    boolean addPersonne(Personne personne);
    boolean deletePersonne(String cin);

    List<Personne> getAllPersonnes();

    Personne loadUserByUsername(String username);





}
