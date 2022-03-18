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

import com.intership.entity.PlaceOrder;
import com.intership.exception.ResourceNotFoundException;
import com.intership.repository.PlaceOrderRepository;

@RestController
public class PlaceOrderController {
	
	@Autowired
	private PlaceOrderRepository placeOrderRepository;
	
	
	//Place Order
		@PostMapping("/orderplace")
		public PlaceOrder orderPlace(@RequestBody PlaceOrder placeOrder) {
			return placeOrderRepository.save(placeOrder);
		}
		
		//find All Order
		@GetMapping("/findallorder")
		public List<PlaceOrder> findAll(){
			return placeOrderRepository.findAll();
		}
		
		//find By id
		@GetMapping("/orderfind/{id}")
		public ResponseEntity<PlaceOrder> findById(@PathVariable Long id) {
			PlaceOrder placeOrder = placeOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order Details is not found by id" +id));
			return ResponseEntity.ok(placeOrder);
		}
		
		//Update Customer Status
		@PutMapping("/orderstatus/{id}")
		public ResponseEntity<PlaceOrder> updateCustomer(@PathVariable Long id, @RequestBody  PlaceOrder details){
			PlaceOrder placeOrder = placeOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order Details is not found by id" +id));
			
			placeOrder.setStatus(details.getStatus());
			
			PlaceOrder updateStatus = placeOrderRepository.save(placeOrder);
			
			return ResponseEntity.ok(updateStatus);
			
		}
		
		//Delete Order
		@DeleteMapping("/order/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
			PlaceOrder placeOrder = placeOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order Details is not found by id" +id));
			
			placeOrderRepository.delete(placeOrder);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
