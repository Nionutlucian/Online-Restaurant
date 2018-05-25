package com.example.Proiect.paw.backend.service;

import com.example.Proiect.paw.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Proiect.paw.backend.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void register(User user){
        if(user.getNume() != null && user.getPrenume() != null && user.getEmail() != null
           && user.getParola() != null && user.getTelefon() != null && user.getAdresa() !=null){

            userRepository.save(user);
        }
    }


    @Transactional
    public User login(String email,String parola){
        if(userRepository.loginQuery(email,parola) != null){
            return userRepository.loginQuery(email,parola);
        }
        else{
            return null;
        }
    }

    public void updateUserDetails(String nume,String email,String adresa,String telefon,String prenume,int id_user){
        userRepository.updateUserDetails(nume,prenume,email,adresa,telefon,id_user);
    }

    public User getUser(int id_user){
        return userRepository.selecyById(id_user);
    }

}
