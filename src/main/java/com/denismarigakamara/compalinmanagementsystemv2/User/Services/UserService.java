package com.denismarigakamara.compalinmanagementsystemv2.User.Services;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.User;
import com.denismarigakamara.compalinmanagementsystemv2.User.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void AddUser(User user){
        userRepo.save(user);
    }

    public List<User>getUsers(String username){
        return userRepo.findUserByUsername(username);
    }
    public User getByID(Long id){
        return userRepo.findById(id).orElse(null);
    }
}
