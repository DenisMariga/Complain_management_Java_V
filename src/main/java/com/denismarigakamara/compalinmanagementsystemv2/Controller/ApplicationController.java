package com.denismarigakamara.compalinmanagementsystemv2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping("/")
    public String index() {
        return "/Index";
    }

    @GetMapping("/register")
    public String register() {
        return "register2";
    }

    @GetMapping("/login")
    public String login() {
        return "login2";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }


    @GetMapping("/adminLogin")
    public String AdminLogin() {
        return "login";
    }
}
