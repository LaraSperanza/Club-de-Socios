package com.unnoba.ClubDeSocios.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter //Getter y Setter nos ahorra escribir éstos.
@Setter
@AllArgsConstructor //Aplica un construtor con todos los atributos.
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String email;
    private String name;
    private String surname;
    private String password;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        try {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        }
    }
    @Override
    public String getUsername() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
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
