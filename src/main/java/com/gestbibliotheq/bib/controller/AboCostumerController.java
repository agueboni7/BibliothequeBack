



package com.gestbibliotheq.bib.controller;

import java.util.List;

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

import com.gestbibliotheq.bib.model.AboCostumer;
import com.gestbibliotheq.bib.services.AboCostumerService;

@CrossOrigin
@RestController
public class AboCostumerController {
	@Autowired
	private AboCostumerService abocostumerservice;
	
	@GetMapping(path="aboCostumers/list")
	public List<AboCostumer> getAboCostumerList(){
		return abocostumerservice.getAboCostumer();
	}
	
	//LISTE DES ABONNEMENTS ¨PAR PACK
	@GetMapping(path="aboCostumers/listParPack")
	public List<Object> listParPack(){
		return abocostumerservice.abonnementParPack();
	}
	
	/////////////////////////
	@GetMapping(path="aboCostumers/listToUpdate")
	public List<AboCostumer> gettesUpdate(){
		return abocostumerservice.testUpdat();
	}
	
	//recupération des dates expirées
	
	@GetMapping(path="aboCostumers/DataExpired")
	public List<AboCostumer> getDtaExpired(){
		return abocostumerservice.getdateExpire();
	}
	
	@GetMapping(path="aboCostumers/expireDansTroisJours")
	public List<AboCostumer> getListDeuxjours(){
		return abocostumerservice.dansDeuxJours();
	}
	
	@GetMapping(path="aboCostumers/expireDansDeuxJours")
	public List<AboCostumer> getListUnJours(){
		return abocostumerservice.dansUnJours();
	}
	
	@GetMapping(path="aboCostumers/expireDansAujourdhuie")
	public List<AboCostumer> getAujourdhuie(){
		return abocostumerservice.dansAjourduie();
	}
	
	
	
	
	//Appel de JPA Perso
	@GetMapping(path="aboCostumers/getByCostumerAbonnement/{id}/{idA}")
	public List<AboCostumer> getAboCostumers(@PathVariable(name="id") Long CostumerId, 
		@PathVariable(name="idA")	Long AbonnementIdA) {
		return abocostumerservice.getAbCosList(CostumerId, AbonnementIdA);
	}
	
	//Appel de JPA Perso
	@GetMapping(path="aboCostumers/getByCostumer/{id}")
	public List<AboCostumer> getAboByCostumers(@PathVariable(name="id") Long CostumerId){
		return abocostumerservice.getByCostumer(CostumerId);
	}
	
	
	
	@DeleteMapping(path="aboCostumers/deletedById/{idAC}")
	public void deleteAboCostumer(@PathVariable(name="idAC") Long idAC) {
		abocostumerservice.abocostumerDelete(idAC);
	}
	
	
	@PostMapping(path="aboCostumers/save")
	public AboCostumer saveAboCostumer(@RequestBody AboCostumer abocostumer) {
		return abocostumerservice.abocostumerSave(abocostumer);
	}
	
	@PutMapping(path="aboCostumers/edit")
	public ResponseEntity<AboCostumer> editAboCostumer(@RequestBody AboCostumer abocostumer){
		AboCostumer editedAboCostumer=abocostumerservice.abocostumerSave(abocostumer);
		
		return new ResponseEntity<AboCostumer>(editedAboCostumer, HttpStatus.OK);
	}
	

	
	
}
