package com.unnoba.ClubDeSocios.controlles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
  @GetMapping("/")
  public String Dashboard(){
    return "login";
  }
}
