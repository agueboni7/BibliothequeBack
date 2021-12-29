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

import com.gestbibliotheq.bib.model.Costumer;
import com.gestbibliotheq.bib.services.CostumerService;

@CrossOrigin
@RestController
public class CostumerController {
	
	@Autowired
	private CostumerService costumerservice;
	
	@GetMapping(path="costumers/list")
	public List<Costumer> getCostumerList(){
		return costumerservice.getCostumer();
	}
	
	@DeleteMapping(path="costumers/deleteById/{id}")
	public void deleteCostumer(@PathVariable(name="id") Long id) {
		costumerservice.costumerDelete(id);
	}
	
	@PostMapping(path="costumers/save")
	public Costumer saveCostumer(@RequestBody Costumer costumer) {
		return costumerservice.costumerSave(costumer);
	}
	
	@PutMapping(path="costumers/edit")
	public ResponseEntity<Costumer> editCostumer(@RequestBody Costumer costumer){
		Costumer editedCostumer=costumerservice.costumerSave(costumer);
		return new ResponseEntity<Costumer>(editedCostumer, HttpStatus.OK);
	}
}
