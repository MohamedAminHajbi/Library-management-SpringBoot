package com.school_project.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school_project.lms.entity.Emprunt;
import com.school_project.lms.entity.Emprunt_mat;
@Repository
public interface Emprunt_matRepository extends JpaRepository<Emprunt_mat, Long> {

	List<Emprunt_mat> findByUserEmail(String email);
}