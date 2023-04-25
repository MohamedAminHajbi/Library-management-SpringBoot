package com.school_project.lms.service;

import java.util.List;
import com.school_project.lms.entity.*;
public interface catalogueService {
    
    List<Catalogue> getAllCatalogues(String keyword);
	Catalogue saveCatalogue(Catalogue catalogue);
	
	Catalogue getCatalogueById(Long id);
	
	Catalogue updateCatalogue(Catalogue catalogue);
	
	void deleteCatalogueById(Long id);
}
