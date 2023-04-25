package com.school_project.lms.service.impl;

import org.springframework.stereotype.Service;
import com.school_project.lms.service.salle_etudesService;
import com.school_project.lms.entity.*;
import com.school_project.lms.repository.salle_etudesRepository;

import java.util.*;


@Service
public class salle_etudesServiceImpl implements salle_etudesService{
    private salle_etudesRepository salle_etudesrepository;
    

    

    public salle_etudesServiceImpl(salle_etudesRepository salle_etudesrepository) {
        this.salle_etudesrepository = salle_etudesrepository;
    }

    @Override
    public List<salle_etudes> getAllSalle_etudes(){
        return salle_etudesrepository.findAll();
    }

    @Override
	public salle_etudes saveSalle_etudes(salle_etudes salle_etudes) {
		return salle_etudesrepository.save(salle_etudes);
	}

	@Override
	public salle_etudes getSalle_etudesById(Long id) {
		return salle_etudesrepository.findById(id).get();
	}

	@Override
	public salle_etudes updateSalle_etudes(salle_etudes salle_etudes) {
		return salle_etudesrepository.save(salle_etudes);
	}

	@Override
	public void deleteSalle_etudesById(Long id) {
		salle_etudesrepository.deleteById(id);
}
}
