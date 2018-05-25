package com.example.Proiect.paw.backend.repository;

import com.example.Proiect.paw.backend.model.Categorie;
import com.example.Proiect.paw.backend.model.Comanda;
import com.example.Proiect.paw.backend.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda,Integer> {

    @Query("select c from Comanda c where c.user_email = ?1")
    List<Comanda> findAllByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Comanda c set c.status= ?1 where c.id_comanda=?2")
    int updateStatusComanda(int status,int id_comanda);
}
