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

import com.gestbibliotheq.bib.model.Book;
import com.gestbibliotheq.bib.services.BookService;

@CrossOrigin
@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping(path="/books/list")
	public List<Book> getListBook(){
		return bookService.getBook();
	}
	
	@DeleteMapping(path="/books/deleteById/{idBo}")
	public void deletedBook(@PathVariable(name="idBo") Long idBo) {
		bookService.bookDelete(idBo);
	}

	@PostMapping(path="/books/save")
	public Book saveBook (@RequestBody Book book) {
		return bookService.bookSave(book);
		 
	}
	
	@PutMapping(path="/books/edit")
	public ResponseEntity<Book>  editBook(@RequestBody Book book) {
		Book editedBook =bookService.bookSave(book);
		return new ResponseEntity<Book>(editedBook, HttpStatus.OK);
	}
}
