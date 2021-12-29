package com.gestbibliotheq.bib.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestbibliotheq.bib.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	 List<Loan>findBytypeInPlaceFalseAndBookIdBoAndCostumerId(Long BookId, Long CostumerId); 

	 List<Loan> findByTypeInPlaceFalseAndAbocostumerIdAC(Long AboCostumerIdAC);
}

