package com.denismarigakamara.compalinmanagementsystemv2.Admin.Controller;

import com.denismarigakamara.compalinmanagementsystemv2.Admin.Entities.Campus;
import com.denismarigakamara.compalinmanagementsystemv2.Admin.Service.CampusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("/Admin/Campus")
public class CampusController {
    private final CampusService campusService;
    public CampusController(CampusService campusService) {
        this.campusService = campusService;
    }

    @GetMapping()
    public Callable<String> Campus(Model model){
        return ()->{
            Thread.sleep(1500);
            List<Campus>campusList=campusService.campusList();
            model.addAttribute("Campus",campusList);
            return "/Admin/Campus";
        };
    }

    @PostMapping("/addNew")
    public Callable<String> AddNew(Campus campus, RedirectAttributes redirectAttributes){
        return ()->{
            Thread.sleep(1500);
            campusService.AddCampus(campus);
            redirectAttributes.addFlashAttribute("Message","Campus Added Successfully");
            return "redirect:/Admin/Campus";
        };
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
    public Callable<String> Delete(@PathVariable Long id){
        return ()->{
            Thread.sleep(1500);
            campusService.delete(id);
            return "redirect:/Admin/Campus";
        };
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public Campus edit(@PathVariable Long id,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("Update","Campus Updated Successfully");
        return campusService.getById(id);
    }
}
