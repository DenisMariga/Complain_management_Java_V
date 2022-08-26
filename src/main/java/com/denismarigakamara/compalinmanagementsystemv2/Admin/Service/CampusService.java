package com.denismarigakamara.compalinmanagementsystemv2.Admin.Service;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Campus;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Repository.CampusRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusService {
    private final CampusRepo campusRepo;

    public CampusService(CampusRepo campusRepo) {
        this.campusRepo = campusRepo;
    }
    //getAll
public List<Campus>campusList(){
       return campusRepo.findAll();
}
//getById
    public Campus getById(Long id){
        return campusRepo.findById(id).orElse(null);
    }
    //AddCampus
    public void AddCampus(Campus campus){
        campusRepo.save(campus);
    }
    //getById
    public void delete(Long id){
         campusRepo.deleteById(id);
    }
}
