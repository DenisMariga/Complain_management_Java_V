package com.denismarigakamara.compalinmanagementsystemv2.User.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardControllerUser {
    @GetMapping("/dashboard")
    public String Dashboard() {
        return "/User/Dashboard";
    }

}
