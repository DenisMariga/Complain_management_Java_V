package com.denismarigakamara.compalinmanagementsystemv2.User.Controller;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Category;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.SubCategory;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.CategoryService;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.SubCategoryServices;
import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Complain;
import com.denismarigakamara.compalinmanagementsystemv2.User.Services.ComplainService;
import com.denismarigakamara.compalinmanagementsystemv2.User.Services.UploadService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/ComplainPost")
public class SendComplainant {
    private final ComplainService complainService;
    private final CategoryService categoryService;
    private final SubCategoryServices subCategoryServices;
    private final UploadService uploadService;

    public SendComplainant(ComplainService complainService, CategoryService categoryService, SubCategoryServices subCategoryServices, UploadService uploadService) {
        this.complainService = complainService;
        this.categoryService = categoryService;
        this.subCategoryServices = subCategoryServices;

        this.uploadService = uploadService;
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @GetMapping()
    public String Complain(Model model) {
        List<Category> categoryList = categoryService.getCategories();
        List<SubCategory> subCategoryList = subCategoryServices.subCategoryList();
        model.addAttribute("Category", categoryList);
        model.addAttribute("SubCategory", subCategoryList);
        return "/User/Complain";
    }

    @PostMapping("/postComplain")
    public String postComplain(Complain complain, ModelMap modelMap, @RequestParam("upload")MultipartFile[] files) {

        for (MultipartFile file: files){
            uploadService.saveUpload(file);
        }
        complain.setUsername(getLoggedInUserName(modelMap));
        complainService.postComplain(complain);
        return "redirect:/ComplainPost";
    }
}
