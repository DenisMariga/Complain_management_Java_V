package com.denismarigakamara.compalinmanagementsystemv2.Admin.Controller;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Category;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.SubCategory;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.CategoryService;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.SubCategoryServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Admin/SubCategory")
public class SubCategoryController {
    private final SubCategoryServices subCategoryServices;
    private final CategoryService categoryService;

    public SubCategoryController(SubCategoryServices subCategoryServices, CategoryService categoryService) {
        this.subCategoryServices = subCategoryServices;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String subCategory(Model model) {
        List<SubCategory> subCategoryList = subCategoryServices.subCategoryList();
        List<Category> categoryList = categoryService.getCategories();
        model.addAttribute("SubCategory",subCategoryList);
        model.addAttribute("Category", categoryList);
        return "/Admin/SubCategory";
    }
    @PostMapping("/addNew")
    public String addNew(SubCategory subCategory){
        subCategoryServices.addSubCategory(subCategory);
        return "redirect:/Admin/SubCategory";
    }
    @RequestMapping("/edit/{id}")
    @ResponseBody
    public SubCategory edit(@PathVariable Long id){
        return subCategoryServices.getById(id);
    }
    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Long id){
        subCategoryServices.deleteById(id);
        return "redirect:/Admin/SubCategory";
    }
}
