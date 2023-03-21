package com.example.pierp.Services;

import com.example.pierp.Models.Client;

public interface ClientService {
    boolean addCLient(Client client);
    boolean verifyClient(String reference);
}
