package io.shangan23.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shangan23.api.exception.ResourceNotFound;
import io.shangan23.api.model.Product;
import io.shangan23.api.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/products/{id}")	
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFound("Product with id " +id+ " not found"));
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFound("Product with id " +id+ " not found"));
		
		product.setDescription(productDetails.getDescription());
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable long id){
		Product product = productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFound("Product with id " +id+ " not found"));
		
		productRepository.delete(product);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
