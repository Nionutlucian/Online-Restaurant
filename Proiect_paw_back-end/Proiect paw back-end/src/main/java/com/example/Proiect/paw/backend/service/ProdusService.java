package com.example.Proiect.paw.backend.service;

import com.example.Proiect.paw.backend.model.Produs;
import com.example.Proiect.paw.backend.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusService {

    @Autowired
    ProdusRepository produsRepository;

    public Produs adaugareProdus(Produs produs){
        return produsRepository.save(produs);
    }

    public List<Produs> getListaProduseByCategorie(int id_categorie){
        return produsRepository.findAllById_categorie(id_categorie);
    }

    public List<Produs> searchByName(String denumire_produs){
        return produsRepository.searchProduct(denumire_produs);
    }

    public List<Produs> findAll(){
        return produsRepository.findAll();
    }

}
