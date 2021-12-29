package com.gestbibliotheq.bib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestbibliotheq.bib.model.Abonnement;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {

	
	
}
