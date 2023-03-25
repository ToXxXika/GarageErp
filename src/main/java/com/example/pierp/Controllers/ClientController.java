package com.example.pierp.Controllers;

import com.example.pierp.Models.Client;
import com.example.pierp.Services.Implementation.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@PreAuthorize("hasAnyAuthority('RESPONSABLE','ADMIN','PARTENAIRE','COMMERCIAL','TECHNICIEN')")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @PostMapping("/verifyclient/{reference}")
    public ResponseEntity<String> verifyClient(@PathVariable("reference") String reference) {
        if(clientService.verifyClient(reference)){
            return new ResponseEntity<>("client found", HttpStatus.OK);
        }
        return new ResponseEntity<>("client not found", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        if(clientService.addCLient(client)){
            return new ResponseEntity<>("client added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("client already exists or bad query", HttpStatus.BAD_REQUEST);
    }


}
