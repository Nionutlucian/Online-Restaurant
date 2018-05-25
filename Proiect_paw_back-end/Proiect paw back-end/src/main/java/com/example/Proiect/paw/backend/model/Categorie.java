package com.example.Proiect.paw.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_categorie;

    @Column(unique = true,nullable = true)
    private String denumire_categorie;

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getDenumire_categorie() {
        return denumire_categorie;
    }

    public void setDenumire_categorie(String denumire_categorie) {
        this.denumire_categorie = denumire_categorie;
    }
}
