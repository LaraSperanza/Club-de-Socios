package com.unnoba.ClubDeSocios.controlles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unnoba.ClubDeSocios.services.MemberService;

@Controller
public class DashboardController {

  @Autowired
  private MemberService memberService;
  
  @GetMapping("/dashboard")
  public String Dashboard(Model model){
    int memberCount = memberService.getMemberCount();
    model.addAttribute("memberCount", memberCount);
    return "dashboard";
  }

}
