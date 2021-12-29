package com.gestbibliotheq.bib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestbibliotheq.bib.model.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long>{

}
