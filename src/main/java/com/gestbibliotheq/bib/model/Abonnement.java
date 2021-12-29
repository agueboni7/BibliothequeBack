package com.gestbibliotheq.bib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abonnement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idA;
	private String code;
	private Integer validite;
	private Integer montant;
	private Integer nbrLivre;
	
	public Abonnement() {
		super();
		
	}

	public Abonnement(Long idA, String code, Integer validite, Integer montant, Integer nbrLivre) {
		super();
		this.idA = idA;
		this.code = code;
		this.validite = validite;
		this.montant = montant;
		this.nbrLivre = nbrLivre;
	}

	public Long getIdA() {
		return idA;
	}

	public void setIdA(Long idA) {
		this.idA = idA;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getValidite() {
		return validite;
	}

	public void setValidite(Integer validite) {
		this.validite = validite;
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public Integer getNbrLivre() {
		return nbrLivre;
	}

	public void setNbrLivre(Integer nbrLivre) {
		this.nbrLivre = nbrLivre;
	}

	@Override
	public String toString() {
		return "Abonnement [idA=" + idA + ", code=" + code + ", validite=" + validite + ", montant=" + montant
				+ ", nbrLivre=" + nbrLivre + "]";
	}

	

	
	
	
	
}
