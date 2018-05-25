package com.example.Proiect.paw.backend.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_comanda;

    @Column(unique = false,nullable = false)
    private Date data_comanda;

    @Column(unique = false)
    private int suma_totala;

    @Column(unique = false)
    private int status;

    @Column(unique = false)
    private String user_nume;

    @Column(unique = false)
    private String user_prenume;

    @Column(unique = false)
    private String user_adresa;

    @Column(unique = false)
    private String user_telefon;

    @Column(unique = false)
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
}
