package com.example.Proiect.paw.backend.rest;

import com.example.Proiect.paw.backend.model.Categorie;
import com.example.Proiect.paw.backend.service.CategorieService;
import com.example.Proiect.paw.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8888", maxAge = 3600)
@RestController
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @RequestMapping(value = "/adaugareCategorie",method = RequestMethod.POST)
    public Categorie adaugareCategorie(@RequestBody Categorie categorie){
        return categorieService.adaugareCategorie(categorie);
    }

    @RequestMapping(value="afisareCategorii",method = RequestMethod.GET)
    public List<Categorie> afisareCategorii(){
        return categorieService.afisareCategorii();
    }

    //TODO:Stergere categorie

    @RequestMapping(value="afisareCategoriiDupaId{id_categorie}",method = RequestMethod.GET)
    public  Categorie afisareCategorieDupaId(@RequestParam String id_categorie){
        int id = Integer.valueOf(id_categorie);
        return categorieService.getCategorieById(id);
    }

    @RequestMapping(value = "/updateCategorie",method = RequestMethod.POST)
    public int updateCategorie(@RequestBody Categorie c){
        return categorieService.updateCategorie(c.getDenumire_categorie());
    }

    @RequestMapping(value = "/stergeCategorie{id}",method = RequestMethod.DELETE)
    public int updateCategorie(@RequestParam String id){
        return categorieService.deleteCategorie(Integer.valueOf(id));
    }

}
