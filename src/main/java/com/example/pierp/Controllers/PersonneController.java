package com.example.pierp.Controllers;

import com.example.pierp.Models.Personne;
import com.example.pierp.Services.Implementation.PersonneServiceImpl;
import com.example.pierp.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")
@CrossOrigin("*")
public class PersonneController {
//TODO: we need to verify if th user is connected or not  and if has a specified role to add a task in the system


    @Autowired
    PersonneServiceImpl personneService;

    @PostMapping("/addp")
    public boolean addPersonne(@RequestBody Personne personne){
        return personneService.addPersonne(personne);
    }
    @PostMapping("/deletep")
    public boolean deletePersonne(@RequestParam(name = "cin") String cin){
        return personneService.deletePersonne(cin);
    }
    @GetMapping("/allp")
    public List<Personne> getAllPersonnes(){
        return personneService.getAllPersonnes();
    }



}
