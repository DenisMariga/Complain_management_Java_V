package com.denismarigakamara.compalinmanagementsystemv2.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class ManageUsersController {
    @GetMapping("/manageUsers")
    public String ManageUsers(){
        return "/Admin/ManageUsers";
    }
}
