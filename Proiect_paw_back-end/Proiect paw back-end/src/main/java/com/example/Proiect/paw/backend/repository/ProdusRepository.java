package com.example.Proiect.paw.backend.repository;

import com.example.Proiect.paw.backend.model.Produs;
import com.example.Proiect.paw.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProdusRepository extends JpaRepository<Produs,Integer> {

    @Query("select p from Produs p where p.id_categorie = ?1")
    List<Produs> findAllById_categorie(int id_categorie);

    @Query("select p from Produs p where p.denumire_produs LIKE CONCAT('%',:username,'%')")
    List<Produs> searchProduct(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("delete from Produs p where p.id_categorie = ?1")
    int deleteCategory(int id_categorie);


}
