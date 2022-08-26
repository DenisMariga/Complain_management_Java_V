package com.denismarigakamara.compalinmanagementsystemv2.User.Services;

import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Complain;
import com.denismarigakamara.compalinmanagementsystemv2.User.Repository.complain;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ComplainService {
    private final complain complainRepo;

    public ComplainService(complain complainRepo) {
        this.complainRepo = complainRepo;
    }

    //Post
    public void postComplain(Complain complain){
        complainRepo.save(complain);
    }
    public List<Complain> getComplain(String user){
      return complainRepo.findComplainByUsername(user);
    }

    public Complain getById(Long id) {
        return complainRepo.findById(id).orElse(null);
    }

}
