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

import com.gestbibliotheq.bib.model.Category;
import com.gestbibliotheq.bib.services.CategoryService;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@GetMapping(path="/categorys/list")
	public List<Category> getCategoryList() {
		return categoryservice.getCategory();
				
	}
	
	@DeleteMapping(path="/categorys/deleteById/{idCat}")
	public void deleteCategory(@PathVariable(name = "idCat") Long idCat) {
		
		categoryservice.CategoryDelete(idCat);
	}
	
	
	@PostMapping(path="/categorys/save")
	public Category saveCategory(@RequestBody Category category) {
		System.out.println(category);
		return categoryservice.categorySave(category);
	}
	
	@PutMapping(path="/categorys/edit")
	public ResponseEntity<Category> editCategory(@RequestBody Category category){
		Category editedCategory=categoryservice.categorySave(category);
		return new ResponseEntity<Category> (editedCategory, HttpStatus.OK);
	}
}
