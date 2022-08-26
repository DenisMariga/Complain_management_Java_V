package com.denismarigakamara.compalinmanagementsystemv2.User.Services;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.User;
import com.denismarigakamara.compalinmanagementsystemv2.User.Repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final UserRepo userRepo;

    public ProfileService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

}
