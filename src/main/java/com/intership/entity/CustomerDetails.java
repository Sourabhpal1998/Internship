package com.intership.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerDetails")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "customer")
	private String customer;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "address")
	private String address;
	
	public CustomerDetails() {
		
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

	public CustomerDetails(String customer, String country, String address) {
		super();
		this.customer = customer;
		this.country = country;
		this.address = address;
	}
	
	
	
	
	
	
	
	
	

}
