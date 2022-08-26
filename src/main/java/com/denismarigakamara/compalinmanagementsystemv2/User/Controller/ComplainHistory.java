package com.denismarigakamara.compalinmanagementsystemv2.User.Controller;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Category;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.SubCategory;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.CategoryService;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.SubCategoryServices;
import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Complain;
import com.denismarigakamara.compalinmanagementsystemv2.User.Entity.Upload;
import com.denismarigakamara.compalinmanagementsystemv2.User.Services.ComplainService;
import com.denismarigakamara.compalinmanagementsystemv2.User.Services.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ComplainHistory {

    private final ComplainService complainService;
    private final CategoryService categoryService;
    private final SubCategoryServices subCategoryServices;
    private final UploadService uploadService;

    public ComplainHistory(ComplainService complainService, CategoryService categoryService, SubCategoryServices subCategoryServices, UploadService uploadService) {
        this.complainService = complainService;
        this.categoryService = categoryService;
        this.subCategoryServices = subCategoryServices;
        this.uploadService = uploadService;
    }

    @GetMapping("/history")
    public String history(Principal principal,Model model) {
        String complain = principal.getName();
        List<Complain>complainList=complainService.getComplain(complain);
        model.addAttribute("Complain",complainList);
        return "/User/History";
    }
    @GetMapping("/HistoryDetails")
    public String historyDetails(Principal principal,Model model){
        String complain = principal.getName();
        String upload = principal.getName();
        List<Complain>complainList=complainService.getComplain(complain);
        model.addAttribute("Complain",complainList);
        List<Category> categoryList=categoryService.getCategoriesByUsername(complain);
        List<SubCategory>subCategoryList=subCategoryServices.subCategoryListByUsername(complain);
        List<Upload>uploads=uploadService.getUpload(upload);
        model.addAttribute("Category",categoryList);
        model.addAttribute("SubCategory",subCategoryList);
        model.addAttribute("Upload",uploads);
        return "/User/HistoryDetails";
    }

}
