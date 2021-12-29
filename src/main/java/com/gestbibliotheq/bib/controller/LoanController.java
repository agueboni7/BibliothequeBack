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

import com.gestbibliotheq.bib.model.Loan;
import com.gestbibliotheq.bib.services.LoanService;

@CrossOrigin
@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanservice;
	
	
	@GetMapping(path="loans/list")
	public List<Loan> getloanList(){
		return loanservice.getLoan();
	}
	
	
	@DeleteMapping(path="loans/deletedById/{idL}")
	public void deleteLoan(@PathVariable(name="idL") Long idL) {
		loanservice.loanDelete(idL);
	
	}
	
	@PostMapping(path="loans/save")
	public Loan saveLoan(@RequestBody Loan loan) {
		return loanservice.loanSave(loan);
	}
	
	@PutMapping(path="loans/edit")
	public ResponseEntity<Loan> editLoan(@RequestBody Loan loan){
		Loan editedLoan= loanservice.loanSave(loan);
		return new ResponseEntity<Loan>(editedLoan, HttpStatus.OK);
	}
	
	//L'implémentation des méthodes personalisée de de JPA
	
	@GetMapping(path="loans/listConsultFalse/{idBo}/{id}")
	public List<Loan> getConsultingFalse(@PathVariable(name="idBo") Long BookId,
			@PathVariable(name="id") Long CostumerId){
		return loanservice.getConsultFalse(BookId, CostumerId);
	}
	
	@GetMapping(path="loan/listLoanCostumerAndAboCostumer/{idAC}")
	public List<Loan>getCostumerAndAboCostumerLoanById(@PathVariable(name="idAC") Long AboCostumerIdAC){
		return loanservice.getFalseByIdAboCostumer(AboCostumerIdAC);
	}
	
	
	

}
