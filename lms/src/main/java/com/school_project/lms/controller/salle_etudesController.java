package com.school_project.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.school_project.lms.entity.*;
import com.school_project.lms.service.salle_etudesService;

@Controller
public class salle_etudesController {
    private salle_etudesService salle_etudesservice;

    

    public salle_etudesController(salle_etudesService salle_etudesservice) {
        this.salle_etudesservice = salle_etudesservice;
    }

    @GetMapping("/salle_etudes")
	public String listSalle_etudes(Model model) {
		model.addAttribute("salle_etudes", salle_etudesservice.getAllSalle_etudes());
		return "salle_etudes";
	}
    
    @GetMapping("/salle_etudes/new")
	public String createSalle_etudesForm(Model model) {
		
		salle_etudes salle_etudes = new salle_etudes();
		model.addAttribute("salle_etudes", salle_etudes);
		return "create_salle_etudes";
		
	}
	
	@PostMapping("/salle_etudes")
	public String saveSalle_etudes(@ModelAttribute ("salle_etudes")  salle_etudes salle_etudes ) {
		salle_etudesservice.saveSalle_etudes(salle_etudes);
		return "redirect:/salle_etudes";
	}
	
	@GetMapping("/salle_etudes/edit/{id}")
	public String editLivreForm(@PathVariable Long id, Model model) {
		model.addAttribute("salle_etudes", salle_etudesservice.getSalle_etudesById(id));
		return "edit_salle_etudes";
	}

	@PostMapping("/salle_etudes/{id}")
	public String updateSalle_etudes(@PathVariable Long id,
			@ModelAttribute("salle_etudes") salle_etudes salle_etudes,
			Model model) {
		
		
		salle_etudes existingsalle_etudes = salle_etudesservice.getSalle_etudesById(id);
		existingsalle_etudes.setId(id);
		existingsalle_etudes.setType_salle(salle_etudes.getType_salle());
        existingsalle_etudes.setDate_debut_reserv(salle_etudes.getDate_debut_reserv());
        existingsalle_etudes.setDate_fin_reserv(salle_etudes.getDate_fin_reserv());
		
		
		salle_etudesservice.updateSalle_etudes(existingsalle_etudes);
		return "redirect:/salle_etudes";		
	}
	
	
	
	@GetMapping("/salle_etudes/{id}")
	public String deleteLivre(@PathVariable Long id) {
		salle_etudesservice.deleteSalle_etudesById(id);
		return "redirect:/salle_etudes";
	}
	
}
