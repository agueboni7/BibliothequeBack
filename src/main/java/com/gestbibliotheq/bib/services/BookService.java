package com.gestbibliotheq.bib.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestbibliotheq.bib.model.Book;
import com.gestbibliotheq.bib.model.Category;
import com.gestbibliotheq.bib.repository.BookRepository;
import com.gestbibliotheq.bib.repository.CategoryRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookrepository;
	private CategoryRepository categoryrepository;
	
	public Optional<Book> getBookById(Long idBo){
		return bookrepository.findById(idBo);
	}
	
	public List<Book> getBook(){
		return bookrepository.findAll();
	}

	public Category getCategory(Long idCat) {
		return categoryrepository.getById(idCat);
	}
	
	//Supprimer BOOK
	public void bookDelete(Long idBo) {
		bookrepository.deleteById(idBo);
	}
	

	public Book bookSave(Book book) {
		Book bookSaved=bookrepository.save(book);
		return bookSaved;
	}
	
	
}
