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
import com.school_project.lms.entity.Emprunt_mat;
import com.school_project.lms.entity.User;
import com.school_project.lms.repository.Emprunt_matRepository;
import com.school_project.lms.repository.UserRepo;
import com.school_project.lms.repository.materielRepository;

@Service
public class Emprunt_matService {

    @Autowired
    private Emprunt_matRepository empRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private materielRepository materielRepo;

    public boolean isMaterielExistsById(long materielID) {
        return materielRepo.existsById(materielID);
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByEmail(auth.getName());
    }
    
    public List<Emprunt_mat> getAllEmpruntMatByUserEmail(String email) {
        return empRepo.findByUserEmail(email);
    }
    public String saveEmpruntMateriel(Emprunt_mat empm) {
        boolean catalogueExists = isMaterielExistsById(empm.getMaterielID());
        if (catalogueExists) {
            empRepo.save(empm);
            
            return "materiels";
        } else {
            return "MaterielNotFound";
        }
    }

	public void deleteEmpruntMaterielById(Long id) {
		empRepo.deleteById(id);
}
}
