package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Client;
import com.example.pierp.Repositories.ClientRepository;
import com.example.pierp.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public boolean addCLient(Client client) {
        try {
            clientRepository.save(client);
            System.out.println("client added successfully");
            return true;
        }catch (Exception e) {
            System.out.println("Cause: "+e.getCause()+" \n Message  : "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean verifyClient(String reference) {
        if(clientRepository.findById(reference).isPresent()){
            System.out.println("client found");
            return true;
        }
        System.out.println("client not found");
        return false;
    }
}
