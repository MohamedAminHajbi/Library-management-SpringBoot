package com.school_project.lms.entity;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "catalogue")
public class Catalogue {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "categorie")
private String categorie;
@Column(name = "name")
private String name;
@Column(name = "date_creation")
private Date date_creation;
@Column(name = "auteur")
private String auteur;
@Column(name = "img")
private String img;
@Column(name = "number")
private String num;

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getCategorie() {
    return categorie;
}
public void setCategorie(String categorie) {
    this.categorie = categorie;
}
public Catalogue(){}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public Catalogue(Long id, String categorie, String name, Date date_creation, String auteur, String img, String num) {
	super();
	this.id = id;
	this.categorie = categorie;
	this.name = name;
	this.date_creation = date_creation;
	this.auteur = auteur;
	this.img = img;
	this.num = num;
}
public Date getDate_creation() {
    return date_creation;
}
public void setDate_creation(Date date_creation) {
    this.date_creation = date_creation;
}
public String getAuteur() {
    return auteur;
}
public void setAuteur(String auteur) {
    this.auteur = auteur;
}

}
