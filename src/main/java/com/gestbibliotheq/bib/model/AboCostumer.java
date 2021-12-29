package com.gestbibliotheq.bib.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AboCostumer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAC;
	private LocalDateTime datDebAC;
	private LocalDateTime datFinAC;
	private Boolean satut;
	private String statutAbo;
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Costumer.class)
	@JoinColumn(name="id", nullable=false, referencedColumnName = "id")
	private Costumer costumer;
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Abonnement.class)
	@JoinColumn(name="idA", nullable=false, referencedColumnName = "idA")
	private Abonnement abonnement;

	public AboCostumer() {
		super();
		
	}

	public AboCostumer(Long idAC, LocalDateTime datDebAC, LocalDateTime datFinAC, Boolean satut, String statutAbo, Costumer costumer,
			Abonnement abonnement) {
		super();
		this.idAC = idAC;
		this.datDebAC = datDebAC;
		this.datFinAC = datFinAC;
		this.satut = satut;
		this.statutAbo = statutAbo;
		this.costumer = costumer;
		this.abonnement = abonnement;
	}



	public Long getIdAC() {
		return idAC;
	}

	public void setIdAC(Long idAC) {
		this.idAC = idAC;
	}

	public LocalDateTime getDatDebAC() {
		return datDebAC;
	}

	public void setDatDebAC(LocalDateTime datDebAC) {
		this.datDebAC = datDebAC;
	}

	public LocalDateTime getDatFinAC() {
		return datFinAC;
	}

	public void setDatFinAC(LocalDateTime datFinAC) {
		this.datFinAC = datFinAC;
	}

	public Boolean getSatut() {
		return satut;
	}

	public void setSatut(Boolean satut) {
		this.satut = satut;
	}
	
	

	public Costumer getCostumer() {
		return costumer;
	}

	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}
	
	

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	public String getStatutAbo() {
		return statutAbo;
	}

	public void setStatutAbo(String statutAbo) {
		this.statutAbo = statutAbo;
	}

	@Override
	public String toString() {
		return "AboCostumer [idAC=" + idAC + ", datDebAC=" + datDebAC + ", datFinAC=" + datFinAC + ", satut=" + satut
				+ ", statutAbo=" + statutAbo + ", costumer=" + costumer + ", abonnement=" + abonnement + "]";
	}
	
	
	
	
}
