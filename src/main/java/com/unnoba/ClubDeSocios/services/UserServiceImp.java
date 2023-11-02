package com.unnoba.ClubDeSocios.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.unnoba.ClubDeSocios.model.User;
import com.unnoba.ClubDeSocios.repositories.UserRepository;


public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
