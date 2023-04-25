package com.school_project.lms.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt_mat")
public class Emprunt_mat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "date_debut_reserv")
    private Timestamp date_debut_reserv;
    @Column(name = "date_fin_reserv")
    private Timestamp date_fin_reserv;
    @Column(name = "mat_id")
    private long materielID;
    public Emprunt_mat() {}
    public Emprunt_mat(String userEmail, Timestamp date_debut_reserv, Timestamp date_fin_reserv, long materielID) {
        this.userEmail = userEmail;
        this.date_debut_reserv = date_debut_reserv;
        this.date_fin_reserv = date_fin_reserv;
        this.materielID = materielID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
    public long getMaterielID() {
        return materielID;
    }
    public void setMaterielID(long materielID) {
        this.materielID = materielID;
    }
    public Emprunt_mat(String userEmail) {
		super();
		this.userEmail = userEmail;
	}
    
	
}