package com.unnoba.ClubDeSocios.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "members")
@AllArgsConstructor
@NoArgsConstructor
public class Member { //POSIBLEMENTE FALTEN AGREGAR ATRIBUTOS
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_member;
  private String member_name;
  private String member_surname;
  private String identity_card; //poner con ck. Lo puse como String porque nos va a permitir usar el "LIKE" en la bd para poder filtrar. Un Integer no.
  private Date birthdate;
  private String phone;
  private String email;
  private Date registration_date;
  private Boolean life_member;
  private Long family_group; //Agregar join a la tabla.
}
