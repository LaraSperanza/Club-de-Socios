package com.unnoba.ClubDeSocios.controlles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.unnoba.ClubDeSocios.services.UserService;
import org.springframework.ui.Model;

import com.unnoba.ClubDeSocios.model.User;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/")
    public String Login(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model){
        userService.create(user);
        model.addAttribute("message", "Registro exitoso.");
        return "register";
    }


}
