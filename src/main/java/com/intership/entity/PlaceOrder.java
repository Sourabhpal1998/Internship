package com.intership.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placeOrder")
public class PlaceOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name = "customer")
	private String customer;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "product_details")
	private String productDetails;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "date")
	private Long date;
	
	@Column(name = "status")
	private String status;
	
	public PlaceOrder() {
		
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PlaceOrder(Long orderId, String customer, String country, String address, String productDetails,
			String productDescription, Long date, String status) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.country = country;
		this.address = address;
		this.productDetails = productDetails;
		this.productDescription = productDescription;
		this.date = date;
		this.status = status;
	}
	
	
	
	

}
