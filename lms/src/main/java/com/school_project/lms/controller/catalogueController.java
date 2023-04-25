package com.school_project.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.school_project.lms.entity.*;
import com.school_project.lms.service.catalogueService;
import org.springframework.data.repository.query.Param;

@Controller
public class catalogueController {
    private catalogueService catalogueservice;

    public catalogueController(catalogueService catalogueservice){
        this.catalogueservice=catalogueservice;
    }

    @GetMapping("/catalogues")
	public String listCatalogues(Model model, @Param("keyword") String keyword) {
		model.addAttribute("catalogue", catalogueservice.getAllCatalogues(keyword));
		return "catalogues";
	}
    
    @GetMapping("/catalogues/new")
	public String createCatalogueForm(Model model) {
		
		Catalogue catalogue = new Catalogue();
		model.addAttribute("catalogue", catalogue);
		return "create_catalogue";
		
	}
	
	@PostMapping("/catalogues")
	public String saveCatalogue(@ModelAttribute ("catalogue")  Catalogue catalogue ) {
		catalogueservice.saveCatalogue(catalogue);
		return "redirect:/catalogues";
	}
	
	@GetMapping("/catalogues/edit/{id}")
	public String editLivreForm(@PathVariable Long id, Model model) {
		model.addAttribute("catalogue", catalogueservice.getCatalogueById(id));
		return "edit_catalogue";
	}

	@PostMapping("/catalogues/{id}")
	public String updateCatalogue(@PathVariable Long id,
			@ModelAttribute("catalogue") Catalogue catalogue,
			Model model) {
		
		
		Catalogue existingLivre = catalogueservice.getCatalogueById(id);
		existingLivre.setId(id);
		existingLivre.setName(catalogue.getName());
		existingLivre.setAuteur(catalogue.getAuteur());
		existingLivre.setImg(catalogue.getImg());
		existingLivre.setDate_creation(catalogue.getDate_creation());
		existingLivre.setNum(catalogue.getNum());
		
		
		catalogueservice.updateCatalogue(existingLivre);
		return "redirect:/";		
	}
	
	
	
	@GetMapping("/catalogues/{id}")
	public String deleteLivre(@PathVariable Long id) {
		catalogueservice.deleteCatalogueById(id);
		return "redirect:/";
	}
	
}