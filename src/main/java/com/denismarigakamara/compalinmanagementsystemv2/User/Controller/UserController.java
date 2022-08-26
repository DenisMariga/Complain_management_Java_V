package com.denismarigakamara.compalinmanagementsystemv2.User.Controller;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.User;
import com.denismarigakamara.compalinmanagementsystemv2.User.Services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addNew")
    public String addNewUser(User user, RedirectAttributes redirect){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.AddUser(user);
        redirect.addFlashAttribute("message", "You successfully signed up! Please login ");
        return "redirect:/login";
    }
}

