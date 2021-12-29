package com.gestbibliotheq.bib.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestbibliotheq.bib.model.Costumer;
import com.gestbibliotheq.bib.repository.CostumerRepository;

@Service
public class CostumerService {
	@Autowired
	private CostumerRepository costumerrepository;
	
	public Optional<Costumer> getCostumerById(Long id){
		return costumerrepository.findById(id);
	}
	
	
	public List<Costumer> getCostumer(){
		return costumerrepository.findAll();
	}
	
	public void costumerDelete(Long id) {
		costumerrepository.deleteById(id);
	}

	public Costumer costumerSave(Costumer costumer) {
		Costumer costumerSaved=costumerrepository.save(costumer);
		return costumerSaved;
	}
}
