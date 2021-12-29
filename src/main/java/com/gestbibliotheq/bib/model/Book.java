package com.gestbibliotheq.bib.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idBo;
	private String isbn;
	private String titre;
	private Date datSortie;
	private Integer nombre;
	private String auteur;
	
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Category.class)
	@JoinColumn(name="idCat", nullable=false)
	private Category category;
	
	public Book() {
		super();}

	public Book(Long idBo, String isbn, String titre, Date datSortie, Integer nombre, String auteur,
			Category category) {
		super();
		this.idBo = idBo;
		this.isbn = isbn;
		this.titre = titre;
		this.datSortie = datSortie;
		this.nombre = nombre;
		this.auteur = auteur;
		this.category = category;
		
	}
	

	public Long getIdBo() {
		return idBo;
	}

	public void setIdBo(Long idBo) {
		this.idBo = idBo;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public Date getDatSortie() {
		return datSortie;
	}

	public void setDatSortie(Date datSortie) {
		this.datSortie = datSortie;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [idBo=" + idBo + ", isbn=" + isbn + ", titre=" + titre + ", datSortie=" + datSortie + ", nombre="
				+ nombre + ", auteur=" + auteur + ", category=" + category + "]";
	}

	
	
}
