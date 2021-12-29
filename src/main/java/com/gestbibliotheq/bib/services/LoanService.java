package com.gestbibliotheq.bib.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestbibliotheq.bib.model.AboCostumer;
import com.gestbibliotheq.bib.model.Book;
import com.gestbibliotheq.bib.model.Costumer;
import com.gestbibliotheq.bib.model.Loan;
import com.gestbibliotheq.bib.repository.AboCostumerRepository;
import com.gestbibliotheq.bib.repository.BookRepository;
import com.gestbibliotheq.bib.repository.CostumerRepository;
import com.gestbibliotheq.bib.repository.LoanRepository;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanrepository;
	private CostumerRepository costumerrepository;
	private BookRepository bookrepository;
	private AboCostumerRepository abocostumerrepository;
	
	
	public AboCostumer getAboCustumer(Long idAC) {
		return abocostumerrepository.getById(idAC);
	}
	public Costumer getCostumer(Long id) {
		return costumerrepository.getById(id);
	}
	
	public Book getBook(Long idBo) {
		return bookrepository.getById(idBo);
	}
	
	
	public Optional<Loan> getLoanById(Long idL){
		return loanrepository.findById(idL);
	}
	
	public List<Loan> getLoan(){
		return loanrepository.findAll();
	}
	
	
	public void loanDelete(Long idL) {
		loanrepository.deleteById(idL);
	}
	

	public Loan loanSave(Loan loan) {
		Loan loanSaved=loanrepository.save(loan);
		return loanSaved;
	}
	
	// Les méthodes personnalisée de JPA
	public List<Loan> getConsultFalse(Long BookId, Long CostumerId) {
		return loanrepository.findBytypeInPlaceFalseAndBookIdBoAndCostumerId(BookId, CostumerId);
	}
	
	
	public List<Loan> getFalseByIdAboCostumer( Long AboCostumerIdAC){
		return loanrepository.findByTypeInPlaceFalseAndAbocostumerIdAC(AboCostumerIdAC );
	}
	
	
	
}
