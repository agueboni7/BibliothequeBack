package com.gestbibliotheq.bib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestbibliotheq.bib.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
