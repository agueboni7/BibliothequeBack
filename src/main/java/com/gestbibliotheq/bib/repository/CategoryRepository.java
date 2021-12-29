package com.gestbibliotheq.bib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestbibliotheq.bib.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
