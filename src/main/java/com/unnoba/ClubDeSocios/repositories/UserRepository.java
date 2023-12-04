package com.unnoba.ClubDeSocios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unnoba.ClubDeSocios.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

  @Query("SELECT u FROM Users u WHERE u.email = :email")
  Users getUserByEmail(@Param("email") String email);

}
