package com.denismarigakamara.compalinmanagementsystemv2.Admin.Controller;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Category;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Admin/Category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping()
    public String Category(Model model) {
        List<Category>categoryList= categoryService.getCategories();
        model.addAttribute("Category",categoryList);
        return "Admin/Category";
    }


    @PostMapping("/addNew")
    public String addNew(Category category, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("Message","Category Added Successfully");
        categoryService.addNew(category);
        return "redirect:/Admin/Category";
    }


    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET , RequestMethod.DELETE})
    public String DeleteCategory(@PathVariable long id){
        categoryService.DeleteCategory(id);
        return  "redirect:/Admin/Category";
    }


    @RequestMapping("/edit/{id}")
    @ResponseBody
    public Category EditCategory(@PathVariable long id, Model model){
//        Category category = categoryService.getCategoryId(id);
//        model.addAttribute("Category",category);
//        return  "redirect:/Admin/Category";
        return categoryService.getCategoryId(id);
    }
}
