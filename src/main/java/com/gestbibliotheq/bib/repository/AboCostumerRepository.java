package com.gestbibliotheq.bib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestbibliotheq.bib.model.AboCostumer;
import com.gestbibliotheq.bib.services.AbonnementParPack;

@Repository
public interface AboCostumerRepository extends JpaRepository<AboCostumer, Long> {
	
	AbonnementParPack abonnementparpack=new AbonnementParPack();
	
	public List<AboCostumer> findByCostumerIdAndAbonnementIdA( Long CostimerId, Long AbonnementIdA);
	
	//reciupérer la liste des abonnemens par pack SELECT abo_costumer.idac, abo_costumer.ida, COUNT(abo_costumer.ida) 
	//AS NOMBRE  FROM abo_costumer GROUP BY abo_costumer.ida, abo_costumer.idac
	@Query(value="SELECT abonnement.code,abonnement.nbr_livre, COUNT(abo_costumer.ida) AS nombre FROM abo_costumer, abonnement WHERE abo_costumer.ida=abonnement.ida GROUP BY abo_costumer.ida, abo_costumer.idac, abonnement.ida", nativeQuery=true)
	public List<Object>  countAbonnementId();
	
	@Query(value="SELECT * FROM abo_costumer GROUP BY abo_costumer.ida, abo_costumer.idac", nativeQuery=true)
	public List<Object>  aboCoAbonnementId();
	
		
	
	
	@Query(value = "SELECT * FROM abo_costumer WHERE id=?1", nativeQuery = true)
	public List<AboCostumer> AbonnementsClient(Long id);
	
	//Récuperation des abonnemnts qui expirentdans trois jours
	@Query(value="SELECT * FROM abo_costumer WHERE  dat_finac-current_date >='0 day' AND dat_finac-current_date<='3 day'", nativeQuery=true)
	public List<AboCostumer> expiredDate();
	
	@Query(value="SELECT * FROM abo_costumer WHERE dat_finac-current_date <='3 day' AND dat_finac-current_date >'2 day'", nativeQuery=true)
	public List<AboCostumer> abonnementExpireDansTrois();
	
	@Query(value="SELECT * FROM abo_costumer WHERE dat_finac-current_date <='2 day' AND dat_finac-current_date >'1 day'", nativeQuery = true)
	public List<AboCostumer> abonnementExpireDansDeuxJours();
	
	@Query(value ="SELECT * FROM abo_costumer WHERE dat_finac-current_date <='1 day' AND dat_finac-current_date >='0 day'", nativeQuery = true)
	public List<AboCostumer> abonnementExpireAujourduie();
	
	
	@Query(value="SELECT * FROM abo_costumer WHERE dat_finac-current_timestamp>=time '00:00' AND dat_finac-current_timestamp<=time'01:00'", nativeQuery = true)
	public List<AboCostumer> getListToUpdate();
	
	public default void upDateAbC(){
		
		//System.out.println(getListToUpdate());
		List<AboCostumer> listExpire= getListToUpdate();
		
		for (int i=0; i<listExpire.size();i++) { 
			  listExpire.get(i).setSatut(false);
			 listExpire.get(i).setStatutAbo("Invalide");
			 
		}
		
		this.saveAll(listExpire);
		
		
	}
		
	

}
