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

import com.intership.entity.CustomerDetails;
import com.intership.exception.ResourceNotFoundException;
import com.intership.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//Create Customer
	@PostMapping("/createcustomer")
	public CustomerDetails createCustomer(@RequestBody CustomerDetails customerDetails) {
		return customerRepository.save(customerDetails);
	}
	
	//find All CustomerDetails
	@GetMapping("/find")
	public List<CustomerDetails> findAll(){
		return customerRepository.findAll();
	}
	
	//find By id
	@GetMapping("/find/{id}")
	public ResponseEntity<CustomerDetails> findById(@PathVariable Long id) {
		CustomerDetails customerDetails = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer Details is not found by id" +id));
		return ResponseEntity.ok(customerDetails);
	}
	
	//Update Customer Details
	@PutMapping("/customer/{id}")
	public ResponseEntity<CustomerDetails> updateCustomer(@PathVariable Long id, @RequestBody CustomerDetails details){
		CustomerDetails customerDetails = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer Details is not found by id" +id));
		
		customerDetails.setCustomer(details.getCustomer());
		customerDetails.setCountry(details.getCountry());
		customerDetails.setAddress(details.getAddress());
		CustomerDetails updateCustomer = customerRepository.save(customerDetails);
		return ResponseEntity.ok(updateCustomer);
		
	}
	
	//Delete Customer
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		CustomerDetails customerDetails = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer Details is not found by id" +id));
		
		customerRepository.delete(customerDetails);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
