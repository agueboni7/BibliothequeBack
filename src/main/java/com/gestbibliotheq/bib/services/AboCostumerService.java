package com.gestbibliotheq.bib.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestbibliotheq.bib.model.AboCostumer;
import com.gestbibliotheq.bib.model.Abonnement;
import com.gestbibliotheq.bib.model.Costumer;
import com.gestbibliotheq.bib.repository.AboCostumerRepository;
import com.gestbibliotheq.bib.repository.AbonnementRepository;
import com.gestbibliotheq.bib.repository.CostumerRepository;

@Service
public class AboCostumerService {
	//@Autowired
	private final AboCostumerRepository abocostumerrepository;
	private final AbonnementRepository abonnementrepository;
	private final CostumerRepository costumerrepository;
	
	
	
	
	
	public AboCostumerService(AboCostumerRepository abocostumerrepository, AbonnementRepository abonnementrepository,
			CostumerRepository costumerrepository) {
		super();
		this.abocostumerrepository = abocostumerrepository;
		this.abonnementrepository = abonnementrepository;
		this.costumerrepository = costumerrepository;
		
	}
	
	

	public Costumer getConstumer(Long id) {
		return costumerrepository.getById(id);
	}
	
	public Abonnement getAbonnement(Long idA) {
		return abonnementrepository.getById(idA);
	}

	public Optional<AboCostumer> getAboCostumerById(Long idAC){
		return abocostumerrepository.findById(idAC);
	}
	
	public List<AboCostumer> getAboCostumer(){
		return abocostumerrepository.findAll();
		
	}
		
	public List<AboCostumer> getByCostumer(Long idCostumer){
		return abocostumerrepository.AbonnementsClient(idCostumer);
		
	}
	
	
	
	public void abocostumerDelete(Long idAC) {
		abocostumerrepository.deleteById(idAC);
	}
	
	
	public AboCostumer abocostumerSave(AboCostumer abocostumer) {
		
		AboCostumer abocostumerSaved=abocostumerrepository.save(abocostumer);
		return abocostumerSaved;
	}
	

	//JPA perso
	
	public List<AboCostumer> getAbCosList(Long CostumerId, Long AbonnementIdA){
		return abocostumerrepository.findByCostumerIdAndAbonnementIdA(CostumerId, AbonnementIdA);
		
	}
	
			//LISTE DES ABONNEMENT PAR PACK
	public List<Object>abonnementParPack(){
		return abocostumerrepository.countAbonnementId();
		
	}
	///////////////////////////////
	public List<AboCostumer> testUpdat(){
		 abocostumerrepository.upDateAbC();
		 return null;
	}
	
	//recupere les abonnement qui expirent dans trois joure
		public List<AboCostumer> getdateExpire(){
			return abocostumerrepository.expiredDate();
				
		}
		
	public List<AboCostumer> dansDeuxJours(){
		return abocostumerrepository.abonnementExpireDansTrois();
	}
	
	public List<AboCostumer> dansUnJours(){
		return abocostumerrepository.abonnementExpireDansDeuxJours();
	}
	
	public List<AboCostumer> dansAjourduie(){
		return abocostumerrepository.abonnementExpireAujourduie();
	}
		
	
	
}
