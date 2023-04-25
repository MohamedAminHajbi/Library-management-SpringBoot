package com.school_project.lms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.school_project.lms.entity.Catalogue;
import com.school_project.lms.entity.Emprunt;
import com.school_project.lms.entity.User;
import com.school_project.lms.repository.EmpruntRepository;
import com.school_project.lms.repository.UserRepo;
import com.school_project.lms.repository.catalogueRepository;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private catalogueRepository catalogueRepo;

    public boolean isCatalogueExistsById(long catalogueId) {
        return catalogueRepo.existsById(catalogueId);
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByEmail(auth.getName());
    }
    
    public List<Emprunt> getAllEmpruntByUserEmail(String email) {
        return empRepo.findByUserEmail(email);
    }
    public String saveEmpruntBook(Emprunt emp) {
        boolean catalogueExists = isCatalogueExistsById(emp.getCatalogueID());
        if (catalogueExists) {
            empRepo.save(emp);
            
            return "catalogues";
        } else {
            return "catalogueNotFound";
        }
    }

	public void deleteEmpruntById(Long id) {
		empRepo.deleteById(id);
}
}