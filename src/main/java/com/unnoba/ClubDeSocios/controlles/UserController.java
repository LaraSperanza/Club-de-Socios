package com.unnoba.ClubDeSocios.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.unnoba.ClubDeSocios.model.User;
import com.unnoba.ClubDeSocios.services.UserService;
import com.unnoba.ClubDeSocios.services.UserServiceImp;

@Controller
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping ("/")
    public String Login(Model model){
        model.addAttribute("user", new User(null, null, null, null, null));
        return "login";
    }
}
