package com.example.Proiect.paw.backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

public class ComandaDTO {

    private int id_comanda;
    private Date data_comanda;
    private int suma_totala;
    private int status;
    private int id_produs_auto;

    public void setId_produs(ArrayList<Integer> id_produs) {
        this.id_produs = id_produs;
    }

    public ArrayList<Integer> getId_produs() {
        return id_produs;
    }

    private ArrayList<Integer> id_produs;

    public ArrayList<Integer> getPret_produs() {
        return pret_produs;
    }

    public void setPret_produs(ArrayList<Integer> pret_produs) {
        this.pret_produs = pret_produs;
    }

    private ArrayList<Integer> pret_produs;

    private String user_nume;
    private String user_prenume;
    private String user_adresa;
    private String user_telefon;
    private String user_email;


    public String getUser_nume() {
        return user_nume;
    }

    public void setUser_nume(String user_nume) {
        this.user_nume = user_nume;
    }

    public String getUser_prenume() {
        return user_prenume;
    }

    public void setUser_prenume(String user_prenume) {
        this.user_prenume = user_prenume;
    }

    public String getUser_adresa() {
        return user_adresa;
    }

    public void setUser_adresa(String user_adresa) {
        this.user_adresa = user_adresa;
    }

    public String getUser_telefon() {
        return user_telefon;
    }

    public void setUser_telefon(String user_telefon) {
        this.user_telefon = user_telefon;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(int id_comanda) {
        this.id_comanda = id_comanda;
    }

    public Date getData_comanda() {
        return data_comanda;
    }

    public void setData_comanda(Date data_comanda) {
        this.data_comanda = data_comanda;
    }

    public int getSuma_totala() {
        return suma_totala;
    }

    public void setSuma_totala(int suma_totala) {
        this.suma_totala = suma_totala;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_produs_auto() {
        return id_produs_auto;
    }

    public void setId_produs_auto(int id_produs_auto) {
        this.id_produs_auto = id_produs_auto;
    }

}
