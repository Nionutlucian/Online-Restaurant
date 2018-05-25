package com.example.Proiect.paw.backend.model;


import javax.persistence.*;

@Entity
@Table(name = "produs_comandat")
public class ProdusComandat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_produs_auto;

    @Column
    private int id_produs;

    @Column
    private int id_comanda;

    @Column
    private int pret_produs;


    public int getPret_produs() {
        return pret_produs;
    }

    public void setPret_produs(int pret_produs) {
        this.pret_produs = pret_produs;
    }

    public int getId_produs_auto() {
        return id_produs_auto;
    }

    public void setId_produs_auto(int id_produs_auto) {
        this.id_produs_auto = id_produs_auto;
    }

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public int getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(int id_comanda) {
        this.id_comanda = id_comanda;
    }
}
