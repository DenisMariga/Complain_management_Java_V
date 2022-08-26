package com.denismarigakamara.compalinmanagementsystemv2.Admin.Service;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.SubCategory;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Repository.SubCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServices {
    private final SubCategoryRepo subCategoryRepo;

    public SubCategoryServices(SubCategoryRepo subCategoryRepo) {
        this.subCategoryRepo = subCategoryRepo;
    }

    //get subCategories
    public List<SubCategory>subCategoryList(){
        return subCategoryRepo.findAll();
    }
    public List<SubCategory>subCategoryListByUsername(String username){
        return subCategoryRepo.findSubCategoryByUsername(username);
    }

    //get byId
    public SubCategory getById(Long id){
        return subCategoryRepo.findById(id).orElse(null);
    }
    //deleteById
    public void  deleteById(Long id){
        subCategoryRepo.deleteById(id);
    }
    //Save
    public void addSubCategory(SubCategory subCategory){
        subCategoryRepo.save(subCategory);
    }
}
