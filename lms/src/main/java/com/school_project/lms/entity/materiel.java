package com.school_project.lms.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiel")

public class materiel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "nom_mat", nullable = false)
private String nom_mat;
@Column(name = "img")
private String img;

public materiel(){}

public materiel(String nom_mat, String img) {
    this.nom_mat = nom_mat;
    this.img = img;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNom_mat() {
    return nom_mat;
}

public void setNom_mat(String nom_mat) {
    this.nom_mat = nom_mat;
}

public String getImg() {
    return img;
}

public void setImg(String img) {
    this.img = img;
}
}

