package com.gestbibliotheq.bib.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestbibliotheq.bib.model.Abonnement;
import com.gestbibliotheq.bib.services.AbonnementService;

@CrossOrigin
@RestController
public class AbonnementController {
	@Autowired
	private AbonnementService abonnementservice;
	
	
	@GetMapping(path="abonnements/list")
	public List<Abonnement> getAbonnementList(){
		return abonnementservice.getAbonnement();
	}
	
	
	@GetMapping(path="abonnements/abonsById/{idA}")
	public Optional<Abonnement> getAbonnementsById(@PathVariable(name="idA") Long idA){
		return abonnementservice.getAbonnementById(idA);
	}
	
	
	
	@DeleteMapping(path="abonnements/deleteById/{idA}")
	public void deleteAbonnement(@PathVariable(name="idA") Long idA) {
		abonnementservice.abonnementDelete(idA);
	}
	
	@PostMapping(path="abonnements/save")
	public Abonnement saveAbonnement(@RequestBody Abonnement abonnement) {
		return abonnementservice.abonnementSave(abonnement);
	}
	
	@PutMapping(path="abonnements/edit")
	public ResponseEntity<Abonnement> editAbonnement(@RequestBody Abonnement abonnement){
		Abonnement editedAbonnemnt=abonnementservice.abonnementSave(abonnement);
		return new ResponseEntity<Abonnement>(editedAbonnemnt, HttpStatus.OK);
	}

}
