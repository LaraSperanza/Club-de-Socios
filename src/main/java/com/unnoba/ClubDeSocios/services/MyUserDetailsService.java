package com.unnoba.ClubDeSocios.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.unnoba.ClubDeSocios.model.Roles;
import com.unnoba.ClubDeSocios.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@AllArgsConstructor
public class MyUserDetailsService implements UserDetails{ 

  private Users user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      Set<Roles> roles = user.getRoles();
      List<SimpleGrantedAuthority> authorities = new ArrayList<>();

      for(Roles role:roles){
          authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
      }
      return authorities;
  }

  @Override
  public String getPassword() {
   return user.getPassword();
  }

  @Override
  public String getUsername() {
   return user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
  
}
