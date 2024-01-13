package com.unnoba.ClubDeSocios.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unnoba.ClubDeSocios.model.Address;
import com.unnoba.ClubDeSocios.model.Member;
import com.unnoba.ClubDeSocios.repositories.AdressRepository;
import com.unnoba.ClubDeSocios.repositories.MemberRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/members")
public class MemberController {

  @Autowired
  private MemberRepository memberRepository;
  
  @Autowired
  private AdressRepository addressRepository;

  @GetMapping("/new")
  public String newMember(Model model){
    model.addAttribute("member", new Member());
    model.addAttribute("adress", new Address());
    return "newMember";
  }

  @PostMapping("/new")
  public String newMember(@ModelAttribute Member member, @ModelAttribute Address address) {
    memberRepository.save(member);
    address.setMember(member);
    addressRepository.save(address);
    return "newMember";
  }
  
}
