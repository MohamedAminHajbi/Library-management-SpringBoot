package com.school_project.lms.service.impl;
import org.springframework.stereotype.Service;

import com.school_project.lms.service.catalogueService;
import com.school_project.lms.entity.*;
import com.school_project.lms.repository.catalogueRepository;

import java.util.*;


@Service
public class catalogueServiceImpl implements catalogueService{
    private catalogueRepository cataloguerepository;
    


    public catalogueServiceImpl(catalogueRepository cataloguerepository) {
        this.cataloguerepository = cataloguerepository;
    }



    @Override
    public List<Catalogue> getAllCatalogues(String keyword){
		if (keyword!=""){
			return cataloguerepository.search(keyword);
		}else{
        return cataloguerepository.findAll();}
    }
    

    @Override
	public Catalogue saveCatalogue(Catalogue catalogue) {
		return cataloguerepository.save(catalogue);
	}

	@Override
	public Catalogue getCatalogueById(Long id) {
		return cataloguerepository.findById(id).get();
	}

	@Override
	public Catalogue updateCatalogue(Catalogue catalogue) {
		return cataloguerepository.save(catalogue);
	}

	@Override
	public void deleteCatalogueById(Long id) {
		cataloguerepository.deleteById(id);
}
}
