package com.school_project.lms.service;

import java.util.List;
import com.school_project.lms.entity.materiel;
public interface materielService {
    List<materiel> getAllMateriels(String keyword);
    
	materiel saveMateriel(materiel materiel);
	
	materiel getMaterielById(Long id);
	
	materiel updateMateriel(materiel materiel);
	
	void deleteMaterielById(Long id);
}

