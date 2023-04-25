package com.school_project.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school_project.lms.entity.Emprunt;
import com.school_project.lms.entity.User;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

	List<Emprunt> findByUserEmail(String email);
}