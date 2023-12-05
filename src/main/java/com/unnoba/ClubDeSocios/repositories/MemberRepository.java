package com.unnoba.ClubDeSocios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unnoba.ClubDeSocios.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

  @Query("SELECT COUNT(*) FROM Member")
  public int getMemberCount(); 
}
