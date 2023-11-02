package com.unnoba.ClubDeSocios.model;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String email;
    private String name;
    private String surname;
    private String password;
}
