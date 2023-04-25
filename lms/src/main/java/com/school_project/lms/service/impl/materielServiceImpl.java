package com.school_project.lms.service.impl;
import org.springframework.stereotype.Service;
import com.school_project.lms.service.materielService;
import com.school_project.lms.entity.*;
import com.school_project.lms.repository.materielRepository;

import java.util.*;


@Service
public class materielServiceImpl implements materielService{
    private materielRepository materielrepository;
    

    public materielServiceImpl(materielRepository materielrepository) {
        this.materielrepository = materielrepository;
    }

	@Override
    public List<materiel> getAllMateriels(String keyword){
		if (keyword!=""){
			return materielrepository.search(keyword);
		}else{
        return materielrepository.findAll();}
    }


    @Override
	public materiel saveMateriel(materiel materiel) {
		return materielrepository.save(materiel);
	}

	@Override
	public materiel getMaterielById(Long id) {
		return materielrepository.findById(id).get();
	}

	@Override
	public materiel updateMateriel(materiel materiel) {
		return materielrepository.save(materiel);
	}

	@Override
	public void deleteMaterielById(Long id) {
		materielrepository.deleteById(id);
}
}
