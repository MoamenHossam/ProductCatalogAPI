package com.example.productCatalog.category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method=RequestMethod.GET, value = "/categories")
	public List<Category> GettAllCategories() {
		return categoryService.listAll();
	}

	@RequestMapping(method=RequestMethod.POST, value = "/categories")
	public String addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		return "category Saved...";
	}
	
	public void populate() {
		categoryService.populateCategory();
	}

}
