package com.gestbibliotheq.bib.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestbibliotheq.bib.model.Abonnement;
import com.gestbibliotheq.bib.repository.AbonnementRepository;

@Service
public class AbonnementService {
	@Autowired
	private AbonnementRepository abonnementrepository;
	
	public Optional<Abonnement> getAbonnementById(Long idA){
		return abonnementrepository.findById(idA);
	}
	
	public List<Abonnement> getAbonnement(){
		return abonnementrepository.findAll();
	}
	
	public void abonnementDelete(Long idA) {
		abonnementrepository.deleteById(idA);
	}

	public Abonnement abonnementSave(Abonnement abonnement) {
		Abonnement abonnementSaved=abonnementrepository.save(abonnement);
		return abonnementSaved;
	}
}
