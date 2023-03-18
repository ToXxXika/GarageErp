package com.example.pierp.Controllers;

import com.example.pierp.Models.Personne;
import com.example.pierp.Services.Implementation.PersonneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")
//@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin("*")
public class PersonneController {
//TODO: we need to verify if th user is connected or not  and if has a specified role to add a task in the system


    @Autowired
    PersonneServiceImpl personneService;

    @PostMapping("/addp")
  //  @PreAuthorize("hasRole('RESPONSABLE')")

    public ResponseEntity<String> addPersonne(@RequestBody Personne personne){
         if(personneService.addPersonne(personne)){
             return new ResponseEntity<>("Personne added successfully", HttpStatus.OK);
         }
            return new ResponseEntity<>("Personne already exists or bad query", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/deletep")
    public ResponseEntity<String> deletePersonne(@RequestParam(name = "cin") String cin){
        if (personneService.deletePersonne(cin)){
            return new ResponseEntity<>("Personne deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Personne doesn't exist or bad query", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/allp")
    public List<Personne> getAllPersonnes(){
        return personneService.getAllPersonnes();
    }



}
