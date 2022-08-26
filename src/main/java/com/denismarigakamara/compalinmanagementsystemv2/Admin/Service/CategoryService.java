package com.denismarigakamara.compalinmanagementsystemv2.Admin.Service;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Category;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    
    //addCategory
    public void addNew(Category category) {
        categoryRepo.save(category);
    }

    //ReadCategory
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }
    //ReadCategory
    public List<Category> getCategoriesByUsername(String username) {
        return categoryRepo.findCategoryByUsername(username);
    }

    //GetByID
    public Category getCategoryId(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    //Delete
    public void DeleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
