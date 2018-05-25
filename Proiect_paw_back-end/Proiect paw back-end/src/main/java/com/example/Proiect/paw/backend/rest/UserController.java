package com.example.Proiect.paw.backend.rest;

import com.example.Proiect.paw.backend.dto.UserLoginDTO;
import com.example.Proiect.paw.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Proiect.paw.backend.service.UserService;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:8888", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    UserService userService;



    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(@RequestBody User user){

         userService.register(user);
    }


    @RequestMapping(value="/login",method = RequestMethod.POST)
    public User login(@RequestBody UserLoginDTO user){

        return  userService.login(user.getEmail(),user.getParola());
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public User update(@RequestBody User user){

        userService.updateUserDetails(user.getNume(),user.getEmail(),user.getAdresa(),user.getTelefon(),user.getPrenume(),user.getId_user());
        return userService.getUser(user.getId_user());
    }

    @RequestMapping(value="/message",method = RequestMethod.GET)
    public String print(){
        return "Merge!";
    }

}
