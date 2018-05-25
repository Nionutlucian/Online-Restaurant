package com.example.Proiect.paw.backend.repository;

import com.example.Proiect.paw.backend.model.Categorie;
import com.example.Proiect.paw.backend.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {

    @Query("select c from Categorie c where c.id_categorie = ?1")
    Categorie findCategorieById(int id_categorie);

    @Transactional
    @Modifying
    @Query("update Categorie c set c.denumire_categorie= ?1")
    int updateUserDetails(String denumire_categorie);

    @Transactional
    @Modifying
    @Query("delete from Categorie c where c.id_categorie = ?1")
    int deleteCategory(int id_categorie);
}
