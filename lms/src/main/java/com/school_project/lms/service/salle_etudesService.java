package com.school_project.lms.service;

import java.util.List;
import com.school_project.lms.entity.salle_etudes;
public interface salle_etudesService {
    List<salle_etudes> getAllSalle_etudes();
    
	salle_etudes saveSalle_etudes(salle_etudes salle_etudes);
	
	salle_etudes getSalle_etudesById(Long id);
	
	salle_etudes updateSalle_etudes(salle_etudes materiel);
	
	void deleteSalle_etudesById(Long id);
}
