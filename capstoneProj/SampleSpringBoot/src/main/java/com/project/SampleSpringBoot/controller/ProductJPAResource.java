package com.project.SampleSpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.SampleSpringBoot.dao.ProductRepository;
import com.project.SampleSpringBoot.entity.Product;
import com.project.SampleSpringBoot.entity.ProductCategory;

@RestController
public class ProductJPAResource {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@GetMapping("/allproduct")
	public List<Product> getAllProducts() 
	{
		return productRepo.findAll();
	}
	
	@GetMapping("/allproduct/{id}")
	public Optional<Product> getProductByID(@PathVariable long id) {
		Optional<Product> product = productRepo.findById((long) id);
		
		if (!product.isPresent())
			throw new ProductNotFound("id-" + id);
		
		return product;
		
	}
	
	@PostMapping("/allproduct")
	public Product saveProducts(@Validated @RequestBody Product product) {
		
		Product savedProduct = productRepo.save(product);
		
		return savedProduct;
		
	}
	
	@DeleteMapping("allproduct/{id}")
	public void deleteUser(@PathVariable long id) {
		productRepo.deleteById(id);
	}
	
	@GetMapping("/allproductByCat/name")
	public List<Product> getProductByCategory(@RequestParam String name) {
		return productRepo.getProductByName(name);
	}

}
