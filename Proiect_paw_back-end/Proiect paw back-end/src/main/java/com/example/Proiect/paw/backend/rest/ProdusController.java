package com.example.Proiect.paw.backend.rest;

import com.example.Proiect.paw.backend.model.Categorie;
import com.example.Proiect.paw.backend.model.Produs;
import com.example.Proiect.paw.backend.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8888", maxAge = 3600)
public class ProdusController {

    @Autowired
    ProdusService produsService;

    @RequestMapping(value = "/adaugareProdus",method = RequestMethod.POST)
    public Produs adaugareProdus(@RequestBody Produs produs){

        return produsService.adaugareProdus(produs);
    }

    @RequestMapping(value = "/afisareProduse{id_categorie}",method = RequestMethod.GET)
    public List<Produs> afisareProduseDupaCategorie(@RequestParam  String id_categorie){
        int id = Integer.valueOf(id_categorie);
        System.out.println(id);
        return produsService.getListaProduseByCategorie(id);
    }

    @RequestMapping(value = "/cautaProdus{denumire}",method = RequestMethod.GET)
    public List<Produs> cautareProduse(@RequestParam  String denumire){
        return produsService.searchByName(denumire);
    }

    @RequestMapping(value = "/afisareProduseToate",method = RequestMethod.GET)
    public List<Produs> afisareProduse(){
        return produsService.findAll();
    }


}
