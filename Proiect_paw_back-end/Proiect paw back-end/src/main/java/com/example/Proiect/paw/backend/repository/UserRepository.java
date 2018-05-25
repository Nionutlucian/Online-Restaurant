package com.example.Proiect.paw.backend.repository;

import com.example.Proiect.paw.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.email = ?1 and u.parola = ?2")
    User loginQuery(String email,String parola);

    @Transactional
    @Modifying
    @Query("update User u set u.nume = ?1, u.prenume = ?2, u.email = ?3, u.adresa = ?4, u.telefon = ?5 where u.id = ?6")
    int updateUserDetails(String nume,String prenume,String email,String adresa,String telefon,int id_user);

    @Query("select u from User u where u.id_user = ?1")
    User selecyById(int id_user);

}
