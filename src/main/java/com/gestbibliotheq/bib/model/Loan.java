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
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idL;
	private Date datDeb;
	private Date datFin;
	private Boolean typeInPlace;
	private String typeOp;
	
	

	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Book.class)
	@JoinColumn(name="idBo", nullable= false)
	public Book book;
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Costumer.class)
	@JoinColumn(name="id", nullable=false)
	public  Costumer costumer;
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=AboCostumer.class)
	@JoinColumn(name="idAC", nullable =true)
	public AboCostumer abocostumer;

	public Loan() {
		super();
		
	}

	public Loan(Long idL, Date datDeb, Date datFin, Boolean typeInPlace, String typeOp, Book book, Costumer costumer,
			AboCostumer abocostumer) {
		super();
		this.idL = idL;
		this.datDeb = datDeb;
		this.datFin = datFin;
		this.typeInPlace = typeInPlace;
		this.typeOp = typeOp;
		this.book = book;
		this.costumer = costumer;
		this.abocostumer = abocostumer;
	}

	public Long getIdL() {
		return idL;
	}

	public void setIdL(Long idL) {
		this.idL = idL;
	}

	public Date getDatDeb() {
		return datDeb;
	}

	public void setDatDeb(Date datDeb) {
		this.datDeb = datDeb;
	}

	public Date getDatFin() {
		return datFin;
	}

	public void setDatFin(Date datFin) {
		this.datFin = datFin;
	}

	public Boolean getTypeInPlace() {
		return typeInPlace;
	}

	public void setTypeInPlace(Boolean typeInPlace) {
		this.typeInPlace = typeInPlace;
	}

	public String getTypeOp() {
		return typeOp;
	}

	public void setTypeOp(String typeOp) {
		this.typeOp = typeOp;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Costumer getCostumer() {
		return costumer;
	}

	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}

	public AboCostumer getAbocostumer() {
		return abocostumer;
	}

	public void setAbocostumer(AboCostumer abocostumer) {
		this.abocostumer = abocostumer;
	}

	@Override
	public String toString() {
		return "Loan [idL=" + idL + ", datDeb=" + datDeb + ", datFin=" + datFin + ", typeInPlace=" + typeInPlace
				+ ", typeOp=" + typeOp + ", book=" + book + ", costumer=" + costumer + ", abocostumer=" + abocostumer
				+ "]";
	}
	
	

	

}
