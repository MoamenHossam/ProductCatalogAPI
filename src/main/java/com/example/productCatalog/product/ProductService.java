package com.example.productCatalog.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> listAll(){
		return productRepo.findAll();
	}
	
	public String addProduct(Product product) {
		productRepo.save(product);
		return "added succesfuly";
	}
	
	public Product getProduct(int id) {
		return productRepo.findById(id).get();
	}

	public List<Product> getProductByName(String name) {
		return productRepo.findByName(name);

	}

	public void updateProduct(int id, Product product) {
		product.setId(id);
		productRepo.save(product);
		
	}

	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		
	}


	

}
