package com.gestbibliotheq.bib.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Costumer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String profession;
	private String postal;
	private String mail;
	private Date datAjout;
	
	
	public Costumer() {
		super();
		
	}


	public Costumer(Long id, String nom, String prenom, String profession, String postal, String mail,
			Date datAjout) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.profession = profession;
		this.postal = postal;
		this.mail = mail;
		this.datAjout = datAjout;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public String getPostal() {
		return postal;
	}


	public void setPostal(String postal) {
		this.postal = postal;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Date getDatAjout() {
		return datAjout;
	}


	public void setDatAjout(Date datAjout) {
		this.datAjout = datAjout;
	}


	@Override
	public String toString() {
		return "Costumer [Id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", profession=" + profession + ", postal="
				+ postal + ", mail=" + mail + ", datAjout=" + datAjout + "]";
	}
	
	
	
}
