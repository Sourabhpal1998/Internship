package com.intership.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.intership.entity.ProductDetails;
import com.intership.exception.ResourceNotFoundException;
import com.intership.repository.ProductRepository;

@RestController
public class ProductDetailsController {
	
	@Autowired
	private ProductRepository productRepository;
	
	//Create Customer
		@PostMapping("/createproduct")
		public ProductDetails createCustomer(@RequestBody ProductDetails productDetails) {
			return productRepository.save(productDetails);
		}
		
		//find All CustomerDetails
		@GetMapping("/findproduct")
		public List<ProductDetails> findAll(){
			return productRepository.findAll();
		}
		
		//find By id
		@GetMapping("/findproduct/{id}")
		public ResponseEntity<ProductDetails> findById(@PathVariable Long id) {
			ProductDetails productDetails = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Details is not found by id" +id));
			return ResponseEntity.ok(productDetails);
		}
		
		//Update Product Details
		@PutMapping("/product/{id}")
		public ResponseEntity<ProductDetails> updateProduct(@PathVariable Long id, @RequestBody ProductDetails details){
			ProductDetails productDetails = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Details is not found by id" +id));
			
			productDetails.setProductTitle(details.getProductTitle());
			productDetails.setProductDescription(details.getProductDescription());
			
			ProductDetails updateProduct = productRepository.save(productDetails);
			return ResponseEntity.ok(updateProduct);
			
		}
		
		//Delete Product
		@DeleteMapping("/product/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteproduct(@PathVariable Long id){
			ProductDetails productDetails = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Details is not found by id" +id));
			
			productRepository.delete(productDetails);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
