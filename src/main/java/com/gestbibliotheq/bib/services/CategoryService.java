package com.gestbibliotheq.bib.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestbibliotheq.bib.model.Category;
import com.gestbibliotheq.bib.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryrepository;
	
	public List<Category> getCategory(){
		return categoryrepository.findAll();
	}
	
	
	public void CategoryDelete(Long idCat) {
		categoryrepository.deleteById(idCat);
	}
	
	public Category categorySave(Category category) {
		Category categorySaved=categoryrepository.save(category);
		return categorySaved;
		
	}
}
