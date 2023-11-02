package com.unnoba.ClubDeSocios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unnoba.ClubDeSocios.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
