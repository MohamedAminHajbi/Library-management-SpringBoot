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
import com.school_project.lms.entity.Emprunt;
import com.school_project.lms.entity.User;
import com.school_project.lms.service.impl.EmpruntService;
import com.school_project.lms.service.impl.UserService;

@Controller
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private UserService userService;

    @GetMapping("/emprunt")
    public String showEmpruntForm(Model model) {
        User user = userService.getCurrentUser();
        Emprunt emprunt = new Emprunt(user.getEmail());
        model.addAttribute("emprunt", emprunt);
        return "getBook";
    }
    @GetMapping("/mybooks")
    public String listEmprunts(Model model) {
        User user = empruntService.getCurrentUser();
        List<Emprunt> emprunt = empruntService.getAllEmpruntByUserEmail(user.getEmail());
        model.addAttribute("emprunt", emprunt);
        return "myBooks";
    }
    
    @PostMapping("/empruntBook")
    public String saveEmprunt(@ModelAttribute("Emprunt") Emprunt emprunt, Model model) {
        String result = empruntService.saveEmpruntBook(emprunt);
        if ("catalogueNotFound".equals(result)) {
            model.addAttribute("errorMessage", "Catalogue not found");
        }
        return "redirect:/catalogues";
    }
    @GetMapping("/emprunt/{id}")
	public String deleteLivre(@PathVariable Long id) {
		empruntService.deleteEmpruntById(id);
		return "redirect:/mybooks";
	}
}
