package com.unnoba.ClubDeSocios.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

  @GetMapping("/new")
  public String newMember(){
    return "newMember";
  }
}
