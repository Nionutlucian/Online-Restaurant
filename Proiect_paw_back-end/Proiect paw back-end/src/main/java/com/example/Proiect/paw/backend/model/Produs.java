package com.example.Proiect.paw.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.jdbc.Blob;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "produs")
public class Produs {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_produs;

    @Column(unique = true,nullable = false)
    private String denumire_produs;

    @Column(unique = false,nullable = false)
    private String pret_produs;

    @Column(unique = false,nullable = false)
    private String detalii_produs;

    @Column(unique = false,nullable = false)
    private String imagine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie", nullable = false,insertable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Categorie categorie;

    @Column(name = "id_categorie")
    private int id_categorie;

    public String getPret_produs() {
        return pret_produs;
    }

    public void setPret_produs(String pret_produs) {
        this.pret_produs = pret_produs;
    }


    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public String getDenumire_produs() {
        return denumire_produs;
    }

    public void setDenumire_produs(String denumire_produs) {
        this.denumire_produs = denumire_produs;
    }

    public String getDetalii_produs() {
        return detalii_produs;
    }

    public void setDetalii_produs(String detalii_produs) {
        this.detalii_produs = detalii_produs;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

}
