package com.unnoba.ClubDeSocios.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
  
  private String identity_card;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthdate;
  
  private String phone;

  private String nacionality;

  private String locality;
  
  private String email;

  private String civil_status;

  private String street;

  private String number;

  private String departament;

  private String floor;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date entry_date;
  
  private Boolean life_member;

  
  private Long family_group; //Agregar join a la tabla.
}
