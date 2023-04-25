package com.school_project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school_project.lms.entity.materiel;
import java.util.*;
import org.springframework.data.jpa.repository.Query;

public interface materielRepository extends JpaRepository<materiel,Long> {
    @Query("SELECT p FROM materiel p WHERE p.nom_mat LIKE %?1%")
    public List<materiel> search(String keyword);
}

