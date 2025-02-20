package com.cg.onlinesweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmart.entity.Product;
import com.cg.onlinesweetmart.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PreAuthorize("permitAll()")
	@GetMapping
	public List<Product> showAllProduct() {
		return productServiceImpl.showAllProduct();
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/{id}")
	public List<Product> getProdyctByCategoryId(@PathVariable (value = "id") int categoryId) {
		return productServiceImpl.getProdyctByCategoryId(categoryId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/{id}")
	public Product addProduct(@RequestBody Product product, @PathVariable (value = "id") int categoryId) {
		return productServiceImpl.addProduct(product, categoryId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productServiceImpl.updateProduct(product);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public String cancelProduct(@PathVariable (value = "id") int productId) {
		productServiceImpl.cancelProduct(productId);
		return "deleted";
	}
}
