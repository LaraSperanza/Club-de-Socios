package com.unnoba.ClubDeSocios.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.unnoba.ClubDeSocios.model.User;
import com.unnoba.ClubDeSocios.repositories.UserRepository;

public class CustomUserDetailsService  implements UserDetailsService{

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findeByEmail(username);
    if(user == null) {
      throw new UsernameNotFoundException("El usuario no fue encontrado");
    }
    return new CustomUserDetails(user);
  }
  
}
