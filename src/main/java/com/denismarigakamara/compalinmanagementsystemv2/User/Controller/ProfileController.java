package com.denismarigakamara.compalinmanagementsystemv2.User.Controller;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.User;
import com.denismarigakamara.compalinmanagementsystemv2.User.Repository.UserRepo;
import com.denismarigakamara.compalinmanagementsystemv2.User.Services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/Profile")
public class ProfileController {
    private final UserRepo userRepo;

    private final UserService userService;

    public ProfileController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    //    private String getLoggedInUserName(ModelMap model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        }
//        return principal.toString();
//    }
    @GetMapping()
    public String profile(Model model, Principal principal) {
        String name = principal.getName();
        List<User> userList = userService.getUsers(name);
        model.addAttribute("Profile", userList);
        return "/User/Profile";
    }

    @GetMapping("/edit/{id}")
    public String editProfile(@PathVariable Long id, Model model) {
        User user = userService.getByID(id);
        model.addAttribute("Profile", user);
        return "/User/Profile";
    }

    @RequestMapping(value = "/editProfile", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(User user, Principal principal) {
        user.setUsername(principal.getName());
        userService.AddUser(user);
        return "redirect:/Profile";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword, Principal principal, RedirectAttributes redirect) {
        System.out.println("Old password" + currentPassword);
        System.out.println("New password" + newPassword);
        String name = principal.getName();
        User currentUser = userRepo.findByUsername(name);
        System.out.println(currentUser.getPassword());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(currentPassword, currentUser.getPassword())) {
            currentUser.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userService.AddUser(currentUser);
            redirect.addFlashAttribute("Password","Your Password has been Successfully Changed");
        }else {
            redirect.addFlashAttribute("PasswordFail","Your Password does not Match");
            return "redirect:/Profile";
        }
        return "redirect:/Profile";
    }
}
