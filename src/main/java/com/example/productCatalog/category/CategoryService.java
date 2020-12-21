package com.example.productCatalog.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;

	public List<Category> listAll() {
		return categoryRepo.findAll();
	}

	public void addCategory(Category category) {
		categoryRepo.save(category);
		
	}
	
	public void populateCategory() {
		Category c1 = new Category();
		c1.setName("Electronics");
		categoryRepo.save(c1);
		c1.setName("Furniture");
		categoryRepo.save(c1);
		c1.setName("Computers");
		categoryRepo.save(c1);
		c1.setName("Mobile Phones");
		categoryRepo.save(c1);
		
	}

	

}
