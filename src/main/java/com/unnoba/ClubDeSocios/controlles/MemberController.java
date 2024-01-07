package com.unnoba.ClubDeSocios.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unnoba.ClubDeSocios.model.Member;
import com.unnoba.ClubDeSocios.repositories.MemberRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/members")
public class MemberController {

  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/new")
  public String newMember(Model model){
    model.addAttribute("member", new Member());
    return "newMember";
  }

  @PostMapping("/new")
  public String newMember(@ModelAttribute Member member) {
      memberRepository.save(member);
      return "newMember";
  }
  
}
