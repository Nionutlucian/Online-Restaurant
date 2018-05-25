package com.example.Proiect.paw.backend.rest;

import com.example.Proiect.paw.backend.model.Categorie;
import com.example.Proiect.paw.backend.model.Comanda;
import com.example.Proiect.paw.backend.model.ComandaDTO;
import com.example.Proiect.paw.backend.model.ProdusComandat;
import com.example.Proiect.paw.backend.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8888", maxAge = 3600)
public class ComandaController {

    @Autowired
    ComandaService comandaService;

    @RequestMapping(value = "/adaugareComanda",method = RequestMethod.POST)
    public void adaugareCategorie(@RequestBody ComandaDTO comandaDTO){
         comandaService.adaugareComanda(comandaDTO);
    }

    @RequestMapping(value="/afisareComenziDupaEmail{email}",method = RequestMethod.GET)
    public List<Comanda> afisareComenziUser(@RequestParam String email){
        return comandaService.selectareComenzi(email);
    }

    @RequestMapping(value ="/afisareComenzi",method = RequestMethod.GET)
    public List<Comanda> afisareComenzi(){
        return comandaService.afisareComenzi();
    }

    @RequestMapping(value = "/updateStatusComanda{status}{id_comanda}",method = RequestMethod.GET)
    public int updateStatusComanda(@RequestParam String status,@RequestParam String id_comanda){
        return comandaService.updateComandaStatus(Integer.valueOf(status),Integer.valueOf(id_comanda));
    }

}
