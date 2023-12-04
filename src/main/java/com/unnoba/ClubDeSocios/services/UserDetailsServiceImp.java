package com.unnoba.ClubDeSocios.services;

import com.unnoba.ClubDeSocios.model.Users;
import com.unnoba.ClubDeSocios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImp implements UserDetailsService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Users user = userRepository.getUserByEmail(email);
    if(user == null){
      throw new UsernameNotFoundException("Usuario no encontrado.");
    }
    return new com.unnoba.ClubDeSocios.services.MyUserDetailsService(user);
  }
  
}
