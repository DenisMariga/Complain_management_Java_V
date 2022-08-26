package com.denismarigakamara.compalinmanagementsystemv2.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class ComplainManageController {
    @GetMapping("/InProcess")
    public String InProcess(){
        return "/Admin/InProcess";
    }
    @GetMapping("/Pending")
    public String Pending(){
        return "/Admin/Pending";
    }
    @GetMapping("/Closed")
    public String Closed(){
        return "/Admin/Closed";
    }
    @GetMapping("/Details")
    public String Details(){
        return "/Admin/ComplainantDetails";
    }

}
