package com.unnoba.ClubDeSocios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unnoba.ClubDeSocios.repositories.MemberRepository;

@Service
public class MemberServiceImp implements MemberService{

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public int getMemberCount() {
    return memberRepository.getMemberCount();
  }
  
}
