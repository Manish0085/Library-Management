package com.example.ELibrary.Controller;

import com.example.ELibrary.Service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class LoginController {


    @Autowired
    private CustomUserService customUserService;


    @GetMapping("/allStd")
    public String getWelcome() {
        return "allStd";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam Set<String> roles) {

        customUserService.registerUser(name, email, username, password, roles);
        return "redirect:/allStd";
    }
}

