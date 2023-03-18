package com.example.pierp.Services.Implementation;

import com.example.pierp.Models.Facture;
import com.example.pierp.Repositories.FactureRepository;
import com.example.pierp.Services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    FactureRepository factureRepository;
    @Override
    public boolean addFacture(Facture facture) throws Exception {
        factureRepository.save(facture);
        return true;

    }

    @Override
    public Facture getFactureByReference(String reference) throws Exception {
      if(factureRepository.findById(reference).isPresent()){
          return factureRepository.findById(reference).get();
      }
      return null;
    }

    @Override
    public List<Facture> getFactures() throws Exception {
        return factureRepository.findAll();
    }

    @Override
    public Facture getFactureByClient(String referenceClient) throws Exception {
        List<Facture> factures = getFactures();
        for (Facture facture:factures) {
            if(facture.getRefClient().equals(referenceClient)){
                return facture;
            }
        }
        return null;
    }
}
