package com.school_project.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.school_project.lms.entity.Emprunt_mat;
import com.school_project.lms.entity.User;
import com.school_project.lms.service.impl.Emprunt_matService;
import com.school_project.lms.service.impl.UserService;
import com.school_project.lms.entity.*;
@Controller
public class Emprunt_matController {

    @Autowired
    private Emprunt_matService emprunt_matService;

    @Autowired
    private UserService userService;

    @GetMapping("/emprunt_mat")
    public String showEmpruntForm(Model model) {
        User user = userService.getCurrentUser();
        Emprunt_mat emprunt_mat = new Emprunt_mat(user.getEmail());
        model.addAttribute("emprunt_mat", emprunt_mat);
        return "getMat";
    }
    @GetMapping("/myEquipments")
    public String listEmprunts(Model model) {
        User user = emprunt_matService.getCurrentUser();
        List<Emprunt_mat> emprunt_mat = emprunt_matService.getAllEmpruntMatByUserEmail(user.getEmail());
        model.addAttribute("emprunt_mat", emprunt_mat);
        return "myEquipments";
    }
    
    @PostMapping("/emprunt_mat")
    public String saveEmprunt(@ModelAttribute("Emprunt_mat") Emprunt_mat emprunt, Model model) {
        String result = emprunt_matService.saveEmpruntMateriel(emprunt);
        if ("MaterielNotFound".equals(result)) {
            model.addAttribute("errorMessage", "Equipment not found");
        }
        return "redirect:/materiels";
    }
    @GetMapping("/emprunt_mat/{id}")
	public String deleteMateriel(@PathVariable Long id) {
		emprunt_matService.deleteEmpruntMaterielById(id);
		return "redirect:/myEquipments";
	}
}

