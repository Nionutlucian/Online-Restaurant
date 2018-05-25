package com.example.Proiect.paw.backend.service;

import com.example.Proiect.paw.backend.model.Categorie;
import com.example.Proiect.paw.backend.repository.CategorieRepository;
import com.example.Proiect.paw.backend.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    ProdusRepository produsRepository;

    public Categorie adaugareCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public List<Categorie> afisareCategorii(){
       return categorieRepository.findAll();
    }

    public Categorie getCategorieById(int id_categorie){
        return categorieRepository.findCategorieById(id_categorie);
    }

    public int updateCategorie(String denumire_categorie){
        return categorieRepository.updateUserDetails(denumire_categorie);
    }

    public int deleteCategorie(int id_categorie){
        produsRepository.deleteCategory(id_categorie);
        return categorieRepository.deleteCategory(id_categorie);
    }



}
