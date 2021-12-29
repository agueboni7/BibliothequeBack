package com.gestbibliotheq.bib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idCat;
	String libele;
	
	public Category() {
		super();

	}
	public Category(Long idCat, String libele) {
		super();
		this.idCat = idCat;
		this.libele = libele;
	}
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	@Override
	public String toString() {
		return "Category [idCat=" + idCat + ", libele=" + libele + "]";
	}

}
