package com.school_project.lms.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salle_etudes")

public class salle_etudes {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "type_salle", nullable = false)
private String type_salle;
@Column(name = "date_debut_reserv", nullable = false)
private Timestamp date_debut_reserv;
@Column(name = "date_fin_reserv", nullable = false)
private Timestamp date_fin_reserv;

public salle_etudes(){}

public salle_etudes(String type_salle, Timestamp date_debut_reserv, Timestamp date_fin_reserv) {
    this.type_salle = type_salle;
    this.date_debut_reserv = date_debut_reserv;
    this.date_fin_reserv = date_fin_reserv;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getType_salle() {
    return type_salle;
}
public void setType_salle(String type_salle) {
    this.type_salle = type_salle;
}
public Timestamp getDate_debut_reserv() {
    return date_debut_reserv;
}
public void setDate_debut_reserv(Timestamp date_debut_reserv) {
    this.date_debut_reserv = date_debut_reserv;
}
public Timestamp getDate_fin_reserv() {
    return date_fin_reserv;
}
public void setDate_fin_reserv(Timestamp date_fin_reserv) {
    this.date_fin_reserv = date_fin_reserv;
}

}
