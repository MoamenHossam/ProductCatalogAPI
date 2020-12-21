package com.example.productCatalog.product;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Contact;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public List<Product> GettAllProducts() {
		return productService.listAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/products/{name}")
	@ApiOperation(value = "find products by name", notes = "the response is a list of products due to the fact that the name is not unique", response = Contact.class)
	public List<Product> getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id) {
		productService.updateProduct(id, product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}

}
