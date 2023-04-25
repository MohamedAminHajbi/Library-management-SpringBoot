package com.school_project.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.school_project.lms.entity.*;
import com.school_project.lms.service.materielService;
import org.springframework.data.repository.query.Param;


@Controller
public class materielController {
    private materielService materielservice;

    public materielController(materielService materielservice) {
        this.materielservice = materielservice;
    }

    @GetMapping("/materiels")
	public String listMateriels(Model model, @Param("keyword") String keyword ) {
		model.addAttribute("materiel", materielservice.getAllMateriels(keyword));
		return "materiels";
	}
    
    @GetMapping("/materiels/new")
	public String createMaterielForm(Model model) {
		
		materiel materiel = new materiel();
		model.addAttribute("materiel", materiel);
		return "create_materiel";
		
	}
	
	@PostMapping("/materiels")
	public String saveMateriel(@ModelAttribute ("materiel")  materiel materiel ) {
		materielservice.saveMateriel(materiel);
		return "redirect:/materiels";
	}
	
	@GetMapping("/materiels/edit/{id}")
	public String editLivreForm(@PathVariable Long id, Model model) {
		model.addAttribute("materiel", materielservice.getMaterielById(id));
		return "edit_materiel";
	}

	@PostMapping("/materiels/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("materiel") materiel materiel,
			Model model) {
		
		// get student from database by id
		materiel existingmateriel = materielservice.getMaterielById(id);
		existingmateriel.setId(id);
		existingmateriel.setNom_mat(materiel.getNom_mat());
		existingmateriel.setImg(materiel.getImg());
		
		// save updated student object
		materielservice.updateMateriel(existingmateriel);
		return "redirect:/";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/materiels/{id}")
	public String deleteLivre(@PathVariable Long id) {
		materielservice.deleteMaterielById(id);
		return "redirect:/";
	}
	
}


