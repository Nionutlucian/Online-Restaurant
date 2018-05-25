package com.example.Proiect.paw.backend.service;

import com.example.Proiect.paw.backend.model.Comanda;
import com.example.Proiect.paw.backend.model.ComandaDTO;
import com.example.Proiect.paw.backend.model.ProdusComandat;
import com.example.Proiect.paw.backend.repository.ComandaRepository;
import com.example.Proiect.paw.backend.repository.ProdusComandatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComandaService {

    @Autowired
    ComandaRepository comandaRepository;

    @Autowired
    ProdusComandatRepository produsComandatRepository;

    public void adaugareComanda(ComandaDTO comandaDTO){
        Comanda comanda = new Comanda();
        comanda.setUser_adresa(comandaDTO.getUser_adresa());
        comanda.setUser_email(comandaDTO.getUser_email());
        comanda.setUser_nume(comandaDTO.getUser_nume());
        comanda.setUser_prenume(comandaDTO.getUser_prenume());
        comanda.setUser_telefon(comandaDTO.getUser_telefon());
        comanda.setData_comanda(comandaDTO.getData_comanda());
        comanda.setStatus(comandaDTO.getStatus());
        comanda.setSuma_totala(comandaDTO.getSuma_totala());
        comandaRepository.save(comanda);

        for(Integer i : comandaDTO.getId_produs()){
            int x = 0;
            ProdusComandat produsComandat = new ProdusComandat();
            produsComandat.setId_comanda(comanda.getId_comanda());
            produsComandat.setId_produs(i);
            produsComandat.setPret_produs(comandaDTO.getPret_produs().get(x));
            produsComandatRepository.save(produsComandat);
            x++;

        }
    }


    public List<Comanda> selectareComenzi(String email){
        return comandaRepository.findAllByEmail(email);
    }

    public List<Comanda> afisareComenzi(){
        return comandaRepository.findAll();
    }

    public int updateComandaStatus(int status,int id_comanda){
        return comandaRepository.updateStatusComanda(status,id_comanda);
    }


}
