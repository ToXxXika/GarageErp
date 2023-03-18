package com.example.pierp.Services;

import com.example.pierp.Models.Facture;

import java.util.List;

public interface FactureService {
    boolean addFacture(Facture facture) throws Exception;
    Facture getFactureByReference(String reference) throws Exception;
    List<Facture> getFactures() throws Exception;

    Facture getFactureByClient(String referenceClient) throws Exception;

}
