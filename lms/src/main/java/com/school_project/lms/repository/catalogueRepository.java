package com.school_project.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school_project.lms.entity.Catalogue;

public interface catalogueRepository extends JpaRepository<Catalogue,Long> {
	@Query("SELECT p FROM Catalogue p WHERE p.categorie LIKE %?1%"
            + " OR p.auteur LIKE %?1%")
    public List<Catalogue> search(String keyword);
}
